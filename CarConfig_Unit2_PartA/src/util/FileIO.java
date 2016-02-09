/*
 * @author Shreyansi Kumar
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

@SuppressWarnings("resource")

public class FileIO {
	private String[] fo = new String [3];
	
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
	 * @param filename
	 * @return
	 */
	public Automobile buildAutomotiveObject(String filename) {
		try {
			File file = new File(filename);
			try {
			if(!file.exists()) {
				throw new AutoException(ErrorType.NO_FILE.ordinal(), "Error: File cannot be found!");
			}
		} catch (AutoException ae) {
			filename = ae.fix(ErrorType.NO_FILE.ordinal());
			try {
				return fileReading(new File(filename));
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
	/**
	 * Read a file to memory.
	 * @param file
	 * @return
	 * @throws IOException
	 */

	
	public Automobile fileReading(File file) throws IOException { 
			FileReader fReader = new FileReader(file);
			BufferedReader buffer = new BufferedReader(fReader);
			String line = buffer.readLine();
			if(line == null)
				return null;	
			fo = firstLine(line);
			String name = fo[0];
			float basePrice = 0;
			int sizeOptionSet = 0;
			try {
				try {
					if(fo[1].equals("") || fo[1].equals(" ")) {
						throw new AutoException(ErrorType.NO_BASEPRICE.ordinal(), "Error: Base price cannot be found!");
					}
				} catch (AutoException ae) {
					fo[1] = ae.fix(ErrorType.NO_BASEPRICE.ordinal());
				} finally {
					basePrice = Float.parseFloat(fo[1]);
				}
				
				sizeOptionSet = Integer.parseInt(fo[2]);
		
			} catch(NumberFormatException e) {
				System.out.println("Error-- " + e.toString());
			}
			Automobile au = new Automobile(name, basePrice, sizeOptionSet);
			for(int i=0; i<sizeOptionSet; i++) {
				line = buffer.readLine();
				if(line == null) {
					return null;
				}
				oneLine(line, i, au);
			}
			buffer.close();
		return au;
	}
	/**
	 * Handle the first line.
	 * @param s
	 * @return
	 */

	public String[] firstLine(String s) {
		String[] st = s.split(",");
		if(st.length != 3) {
			return null;
		}
		fo = st;
		
		return fo;
	}
	/**
	 * Handle one line at a time.
	 * @param s is a String
	 * @param opsetNumber is the No. of OptionSet
	 * @param au is an instance of Automotive.
	 */
	public void oneLine(String s, int opsetNumber, Automobile au) {
		String[] s_part = s.split(":");
		String optionSetName = s_part[0];
		String[] pair = s_part[1].split(",");
		int size_OptionSet = pair.length;
		au.setOptionSet(opsetNumber, optionSetName, size_OptionSet);
		String[] word;
		for(int i=0; i<size_OptionSet; i++) {
			word = pair[i].split("\\$");
			try {
				if(word[1].equals(" ")) {
					throw new AutoException(ErrorType.NO_OPTIONPRICE.ordinal(), "Error: Price cannot be found!");
				}
			} catch(AutoException ae) {
				word[1] = ae.fix(ErrorType.NO_OPTIONPRICE.ordinal());		
			} finally {
			au.setOption(opsetNumber, i, word[0], Float.parseFloat(word[1]));
			}
		}
	}
	}