/* @author Shreyansi Kumar
 * 
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

import exception.AutoException;
import exception.ErrorType;
import model.OptionSet.Option;

public class Automobile implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private float basePrice;

	
	private String make;
	private String model;
	private ArrayList<OptionSet> optionSet;
	private ArrayList<Option> choice;
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * Automobile object being initialised
	 */
	public Automobile() {
	}
	/**
	 * Automobile object being initialised with values
	 */
	public Automobile(String make, String model, float basePrice) {
		this.make = make;
		this.model = model;
		this.basePrice = basePrice;
		this.optionSet = new ArrayList<OptionSet>();
		this.choice = new ArrayList<Option>();
	}

	/**
	 * OptionSet object being initialised
	 */
	public void setOptionSet(String optSetName) {
		try {
			if(optSetName.equals("") || optSetName.equals(" ")) {
				throw new AutoException(ErrorType.NO_OPTIONSETNAME.ordinal(), "Error: The OptionSet name cannot be found!");
			}
		} catch(AutoException ae) {
			AutoException.log(ae);
			optSetName = ae.fix(ErrorType.NO_OPTIONSETNAME.ordinal());
		} finally {
		optionSet.add(new OptionSet(optSetName));
		}
	}

	/**
	 * Option object initialised
	 */
	public void setOption(int optSetNumber, String name, float price) {
		optionSet.get(optSetNumber).setOption(name, price);
	}
		
	public OptionSet getOptionSet(int n) {
		return optionSet.get(n);
	}
	
	public String getOptionSetName(int n) {
		return optionSet.get(n).getName();
	}
	
	public int getOptionSetSize() {
		return optionSet.size();
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
		System.out.println("Make: " + make + "\nModel: " + model + "\nBase Price: $" + basePrice + "\n");
		for (int i=0; i<optionSet.size(); i++) {
			if (optionSet.get(i) != null)
				optionSet.get(i).print();
		}
		System.out.println("");
	}
	
	public void printChoice() {
		for(int i=0; i<optionSet.size(); i++) {
			optionSet.get(i).printChoice();
		}
	}
	
	public void setOptionChoice(String setName, String optionName) {
		for(int i=0; i<optionSet.size(); i++) {
			if(optionSet.get(i).getName().equals(setName)) {
				optionSet.get(i).setChoice(optionName);
			}
		}
	}
	
	public String getChoice(String setName) {
		for(int i=0; i<optionSet.size(); i++) {
			if(optionSet.get(i).getName().equals(setName)) {
				return optionSet.get(i).getOptionChoiceName();
			}
		}
		return null;
	}
	
	public float getOptionChoicePrice(String setName) {
		for(int i=0; i<optionSet.size(); i++) {
			if(optionSet.get(i).getName().equals(setName)) {
				return optionSet.get(i).getOptionChoicePrice();
			}
		}
		return 0;
	}

	
	public float getTotalPrice() {
		setChoiceList();
		float sum = basePrice;
		for(int i=0; i<choice.size(); i++) {
			sum += choice.get(i).getPrice();
		}
		return sum;
	}
	/**
	 * Track Choices
	 */
	public void setChoiceList() {
		for(int i=0; i<optionSet.size(); i++) {
			choice.add(optionSet.get(i).getChoice());
		}
	}
	
	/**
	 * Find the OptionSet with names.
	 * @return opset[i] is to be found.
	 */
	public OptionSet findOptionSet(String name) {
		for(int i=0; i<optionSet.size(); i++) {
			if(optionSet.get(i).getName().equals(name)) {
				 System.out.println("The output is " + optionSet.get(i).getName() + ".");
				 return optionSet.get(i);
			}
		}
		System.out.println(name + " cannot be found!");
		return null;
	}
	/**
	 * Find the Option with names.
	 * @return option is  to be found.
	 */
	public Option findOption(String name) {
		for(int i=0; i<optionSet.size();i++) {
			Option option = optionSet.get(i).findOption(name);
			if(option != null) {
				return option;
			}
		}
		System.out.println(name + " cannot be found!");
		return null;
	}
	/**
	 * Update data in OptionSet with names.
	 * @param name1 is an existing array element.
	 * @param name2 is another element for name1.
	 * @throws AutoException 
	 */
	public void updateOptionSet(String name1, String name2) throws AutoException {
		for(int i=0; i<optionSet.size(); i++) {
			if(optionSet.get(i).getName().equals(name1)) {
				optionSet.get(i).setName(name2);
				return;
			}
		}
		throw new AutoException(ErrorType.NO_OPTIONSETNAME.ordinal(), "Error: The OptionSet name cannot be found");
	}
	/**
	 * Update data in Option with names and the name of OptionSet.
	 * @param optionSetName
	 * @param optionName
	 * @param newName
	 */
	public void updateOptionName(String optionSetName, String optionName, String newName) {
		for(int i=0; i<optionSet.size(); i++) {
			if(optionSet.get(i).getName().equals(optionSetName)) {
				optionSet.get(i).updateOptionName(optionName, newName);
				return;
			}
		}
		System.out.println(optionSetName + " cannot be found!");
	}
	
	/**
	 * Update the price in Option by finding its name and the name of OptionSet.
	 * @param name is an existing array element.
	 * @param newPrice is a new element for name.
	 */
	public void updateOptionPrice(String optionSetName, String optionName, float newPrice) throws AutoException {
		for(int i=0; i<optionSet.size(); i++) {
			if(optionSet.get(i).getName().equals(optionSetName)) {
				optionSet.get(i).updateOptionPrice(optionName, newPrice);
				return;
			}
		}
	
	}
	
	
	/**
	 * Delete data in OptionSet.
	 * @param name is to be deleted.
	 */
	public void deleteOptionSet(String name) {
		for(int i=0; i<optionSet.size(); i++) {
			if(optionSet.get(i).getName().equals(name)) {
				optionSet.set(i,null);
				return;
			}
		}
		System.out.println(name + " cannot be found!");
	}
	/**
	 * Delete data in Option.
	 * @param name is to be deleted.
	 */
	public void deleteOption(String name) {
		for(int i=0; i<optionSet.size(); i++) {
			if(optionSet.get(i).findOption(name) != null) {
				optionSet.get(i).deleteOption(name);
				return;
			}
		}
		System.out.println(name + " cannot be found!");
	}
}