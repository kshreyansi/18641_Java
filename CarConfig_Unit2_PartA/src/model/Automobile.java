/**
 * @author Shreyansi Kumar
*/
package model;

import java.io.Serializable;

import exception.AutoException;
import exception.ErrorType;
import model.OptionSet.Option;

public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private float basePrice;
	private OptionSet optionSet[];
	/**
	 * Automobile object initialised
	 */
	public Automobile() {
	}
	/**
	 * Initialised with values
	 */
	public Automobile(String name, float basePrice, int size) {
		this.name = name;
		this.basePrice = basePrice;
		this.optionSet = new OptionSet[size];
	}
	/**
	 * OptionSet object initialised
	 */
	public void setOptionSet(int opsetNumber, String name, int optionSetSize) {
		try {
			if(name.equals("") || name.equals(" ")) {
				throw new AutoException(ErrorType.NO_OPTIONSETNAME.ordinal(), "Error: The OptionSet name cannot be found!");
			}
		} catch(AutoException ae) {
			name = ae.fix(ErrorType.NO_OPTIONSETNAME.ordinal());
		} finally {
		optionSet[opsetNumber] = new OptionSet(name, optionSetSize);
		}
	}
	
	/**
	 * Option object initialised
	 */
	public void setOption(int opsetNumber, int optNumber, String name, float price) {
		optionSet[opsetNumber].setOption(optNumber, name, price);
	}
	
	public OptionSet getOptionSet(int n) {
		return optionSet[n];
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	/**
	 * Print data 
	 */
	public void print() {
		System.out.println("Model: " + name + "\nBase Price: $" + basePrice + "\n");
		for (int i = 0; i < optionSet.length; i++) {
			if (optionSet[i] != null)
				optionSet[i].print();
		}
		System.out.println("");
	}
	/**
	 * Find the OptionSet with names.
	 * @return optionSet[i] 
	 */
	public OptionSet findOptionSet(String name) {
		for(int i=0; i<optionSet.length; i++) {
			if(optionSet[i].getName().equals(name)) {
				 System.out.println("The output is " + optionSet[i].getName() + ".");
				 return optionSet[i];
			}
		}
		System.out.println(name + " cannot be found!");
		return null;
	}
	/**
	 * Find the Option with names.
	 * @return option is to be searched.
	 */
	public Option findOption(String name) {
		for(int i=0; i<optionSet.length;i++) {
			Option option = optionSet[i].findOption(name);
			if(option != null) {
				return option;
			}
		}
		System.out.println(name + " cannot be found!");
		return null;
	}
	/**
	 * Update data in OptionSet with names.
	 * @param name1 is an existing array element
	 * @param name2 is another element for name1.
	 */
	public void updateOptionSet(String name1, String name2) {
		for(int i=0; i<optionSet.length; i++) {
			if(optionSet[i].getName().equals(name1)) {
				optionSet[i].setName(name2);
				return;
			}
		}
		System.out.println(name1 + " cannot be found!");
	}
	/**
	 * Update Option with names and the name of OptionSet.
	 */
	public void updateOption(String optionSetName, String optionName, String newName) {
		for(int i=0; i<optionSet.length; i++) {
			if(optionSet[i].getName().equals(optionSetName)) {
				optionSet[i].updateOption(optionName, newName);
				return;
			}
		}
		System.out.println(optionSetName + " cannot be found!");
	}
	/**
	 * Update Option with names.
	 * @param name1 is an existing array element.
	 * @param name2 another element for name1.
	 */
	public void updateOption(String name1, String name2) {
		for(int i=0; i<optionSet.length; i++) {
			Option option = optionSet[i].findOption(name1);
			if(option != null) {
				optionSet[i].updateOption(name1, name2);
				return;
			}
		}
		System.out.println(name1 + " is not found!");
	}
	/**
	 * Update the price in Option.
	 * @param name is an existing array element
	 * @param newPrice is another element for name.
	 */
	public void updateOption(String optionSetName, String optionName, float newPrice) {
		for(int i=0; i<optionSet.length; i++) {
			if(optionSet[i].getName().equals(optionSetName)) {
				optionSet[i].updateOption(optionName, newPrice);
				return;
			}
		}
		System.out.println(optionSetName + " cannot be found!");
	}
	/**
	 * Update the price in Option.
	 * @param name is an existing array element.
	 * @param newPrice is another element for name.
	 */
	public void updateOption(String name, float newPrice) {
		for(int i=0; i<optionSet.length; i++) {
			if(optionSet[i].findOption(name) != null) {
				optionSet[i].updateOption(name, newPrice);
				return;
			}
		}
		System.out.println(name + " cannot be found!");
	}
	/**
	 * Delete data from OptionSet.
	 * @param name is the data to be deleted.
	 */
	public void deleteOptionSet(String name) {
		for(int i=0; i<optionSet.length; i++) {
			if(optionSet[i].getName().equals(name)) {
				optionSet[i] = null;
				return;
			}
		}
		System.out.println(name + " cannot be found!");
	}
	/**
	 * Delete data from Option.
	 * @param name is the data to be deleted.
	 */
	public void deleteOption(String name) {
		for(int i=0; i<optionSet.length; i++) {
			if(optionSet[i].findOption(name) != null) {
				optionSet[i].deleteOption(name);
				return;
			}
		}
		System.out.println(name + " cannot be found!");
	}
}
