package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Automotive;

@SuppressWarnings("resource")

public class FileIO {
	/**
	 * Serialization
	 * 
	 */
	public Automotive serializeAutomotive(Automotive auto) {
		Automotive staff = new Automotive();
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Automotive.dat"));
			out.writeObject(auto);
			out.close();
			
			ObjectInputStream in =  new ObjectInputStream(new FileInputStream("Automotive.dat"));
			staff = (Automotive) in.readObject();
		} catch(Exception e) {  
			System.out.print("Error: is " + e.toString());
			System.exit(1);
		}
		return staff;
	}
	/**
	 * Build Automobile Object from a file.
	 * @param filename
	 * @return
	 */
	public Automotive buildAutomotiveObject(String filename) {
		File file = new File(filename);
		try {
			return fileReading(file);
		} catch (IOException e) {
			System.out.println("Error is" + e.toString());
			return null;
		}
	}
	/**
	 * Read a file to memory.
	 */
	public Automotive fileReading(File file) throws IOException { 
			FileReader fr = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fr);
			String line = buffer.readLine();
			if(line == null)
				return null;	
			int sizeOptionSet = firstLine(line);
			String name = "Focus Wagon ZTW";
			float basePrice = 18445;
			Automotive auto = new Automotive(name, basePrice, sizeOptionSet);
			for(int i=0; i<sizeOptionSet; i++) {
				line = buffer.readLine();
				if(line == null) {
					return null;
				}
				oneLine(line, i, auto);
			}
			buffer.close();
		return auto;
	}
	/**
	 * Handle the first line.
	 */
	public int firstLine(String s) {
		String[] st = s.split(",");
		if(st.length < 3) {
			return 0;
		}
		
		int number = 0;
		try {
		    number = Integer.parseInt(st[2]);
		} catch(NumberFormatException e) {
			System.out.println("Error is " + e.toString());
		}
		return number;
	}
	/**
	 *
	 * Handle one line at a time
	 */
	public void oneLine(String s, int num_opset, Automotive auto) {
		String[] first_part = s.split(":");
		String optionSetName = first_part[0];
		String[] pair = first_part[1].split(",");
		int size_OptionSet = pair.length;
		auto.setOptionSet(num_opset, optionSetName, size_OptionSet);
		String[] temp;
		for(int i=0; i<size_OptionSet; i++) {
			temp = pair[i].split("\\$");
			auto.setOption(num_opset, i, temp[0], Float.parseFloat(temp[1]));
		}
	}
}