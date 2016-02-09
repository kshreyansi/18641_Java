/* @author Shreyansi Kumar
 * 
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exception.AutoException;
import exception.ErrorType;
import model.Automobile;
public class FileIO {
	private String[] fl = new String [3];
	
	/**
	 * Serialization
	 * @param au is an instance of Automotive
	 * @return
	 */
	public Automobile serializeAutomotive(Automobile au) {
		Automobile staff = new Automobile();
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Automotive.dat"));
			out.writeObject(au);
			out.close();
			
			ObjectInputStream in =  new ObjectInputStream(new FileInputStream("Automotive.dat"));
			staff = (Automobile) in.readObject();
		} catch(Exception e) {  
			System.out.print("Error: " + e.toString());
			System.exit(1);
		}
		return staff;
	}
	/**
	 * Build Automobile Object from a file.
	 * @param fileName
	 * @return
	 */
	
	public Automobile buildAutomotiveObject(String fileName) {
		try {
			//System.out.println("in fileio");
			File file = new File(fileName);
			try {
				
			if(!file.exists()) {
				throw new AutoException(ErrorType.NO_FILE.ordinal(), "Error: File cannot be found!");
			}
		} catch (AutoException ae) {
			AutoException.log(ae);
			fileName = ae.fix(ErrorType.NO_FILE.ordinal());
			try {
				return fileReading(new File(fileName));
			} catch (IOException e) {
				System.out.println("Error" + e.toString());
				return null;
			}
		}
			
			return fileReading(file);
			
			
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
			return null;
		}
	}

	
	public Automobile fileReading(File file) throws IOException { 
			FileReader fReader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fReader);
			String line = buffer.readLine();
			fl = firstLine(line);
			if(line == null)
				return null;
			String make = fl[0].trim();
			String model = fl[1].trim();
			float basePrice = 0;
		
			try {
				try {
					if(fl[2].equals("") || fl[2].equals(" ")) {
						throw new AutoException(ErrorType.NO_BASEPRICE.ordinal(), "Error: Base price cannot be found!");
					}
				} catch (AutoException ae) {
					AutoException.log(ae);
					fl[2] = ae.fix(ErrorType.NO_BASEPRICE.ordinal());
				} finally {
					basePrice = Float.parseFloat(fl[2]);
				}
				

			} catch(NumberFormatException e) {
				System.out.println("Error-- " + e.toString());
			}
			Automobile au = new Automobile(make, model, basePrice);
			boolean eof = false;
			int optSetNumber = 0;
			while(!eof) {
				line = buffer.readLine();
				if(line == null) {
					eof = true;
				}
				else {
					oneLine(line, optSetNumber, au);
				}
				optSetNumber++;
			}

			buffer.close();
		return au;
	}
	
	public String[] firstLine(String s) {
		String[] st = s.split(",");
		if(st.length != 3) {
			return null;
		}
		fl = st;
		
		return fl;
	}
	/**
	 * Handle one line at a time
	 * @param s is a String
	 * @param opsetNumber is the No. of OptionSet
	 * @param au is an instance of Automotive.
	 */
	public void oneLine(String s, int opsetNumber, Automobile au) {
		String[] s_part = s.split(":");
		String optionSetName = s_part[0];
		String[] pair = s_part[1].split(",");
		int size_OptionSet = pair.length;
		au.setOptionSet(optionSetName);
		String[] word;
		for(int i=0; i<size_OptionSet; i++) {
			word = pair[i].split("\\$");
			try {
				if(word[1].equals(" ")) {
					throw new AutoException(ErrorType.NO_OPTIONPRICE.ordinal(), "Error: Price cannot be found!");
				}
			} catch(AutoException ae) {
				AutoException.log(ae);
				word[1] = ae.fix(ErrorType.NO_OPTIONPRICE.ordinal());		
			} finally {
			au.setOption(opsetNumber, word[0].trim(), Float.parseFloat(word[1]));
			}
		}
	}

}