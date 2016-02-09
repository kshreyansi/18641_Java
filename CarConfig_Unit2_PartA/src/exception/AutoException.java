/*
 * @author Shreyansi Kumar
 */
package exception;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String logFile = "C:/Users/Shreyanshi/Desktop/logfile.txt";
	private String msg;
    private int ErrType;	

	public AutoException() {
		
	}
	
	public AutoException(int ErrType, String msg) {
		this.ErrType= ErrType;
		this.msg = msg;
	}	

	public String fix(int errNumber) {
		Fix1to5 helper = new Fix1to5();
		log();
		return helper.fix(errNumber);
	}

public void log() {
	try {
		FileWriter file = new FileWriter(logFile, true);
		BufferedWriter writer = new BufferedWriter(file);
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String dateString = dateFormat.format(now);
		
		writer.write(dateString + "\n ");
		switch(ErrType) {
		case 0:
			writer.write("\nIncorrect File Directory\n");
			break;
		case 1:
			writer.write("\nBase price missing\n");
			break;
		case 2:
			writer.write("\nOption Set Name missing\n");
			break;
		case 3:
			writer.write("\nOption Name missing\n");
			break;
		case 4:
			writer.write("\nOption price missing\n");
			break;
		default:
			writer.write("\nUnknown error.\n");
			break;
		}
		
		writer.write("\n");
		writer.flush();
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}