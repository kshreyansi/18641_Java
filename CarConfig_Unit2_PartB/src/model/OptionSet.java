package model;

import java.io.Serializable;
import java.util.ArrayList;

import exception.AutoException;
import exception.ErrorType;

public class OptionSet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Option> opt;
	private Option choice;
	/**
	 * OptionSet object initilaised.
	 */
	protected OptionSet(String optSetName) {
		this.name = optSetName; 
		opt = new ArrayList<Option>(); 
	}
	/**
	 * Option object initialized.
	 */
	protected void setOption(String name, float price) {
		try {
			if(name.equals("") || name.equals(" ")) {
				throw new AutoException(ErrorType.NO_OPTIONNAME.ordinal(), "Error: The Option name cannot be found!");
			}
		} catch(AutoException ae) {
			AutoException.log(ae);
			name = ae.fix(ErrorType.NO_OPTIONNAME.ordinal());
		} finally {
		opt.add(new Option(name, price));
		}
	}

	/**
	 * Print data.
	 */
	protected void print(){
		System.out.println(name+": " );
		for(int i = 0;i<opt.size();i++){
			if(opt.get(i)!=null) {
				opt.get(i).print();
			}
		}
		System.out.println("");
	}
	
	protected void printChoice() {
		System.out.println(choice.name + ": $" + choice.price);
	}

	protected void setName(String name) {
		this.name = name;
	}
	
	protected String getName() {
		return name;
	}
	/**
	 * Set the choice
	 * @param nameChoice
	 */
	protected void setChoice(String nameChoice) {
		choice = findOption(nameChoice);
	}
	/**
	 * In the Optionset Get the choice 
	 * @return
	 */
	protected Option getChoice() {
		if(choice != null) {
			return choice;
		}
		return choice;
	}
	/**
	 * Get the name of the choice.
	 * @return
	 */
	protected String getOptionChoiceName() {
		return choice.name;
	}
	/**
	 * Get the price of the choice.
	 * @return
	 */
	protected float getOptionChoicePrice() {
		return choice.price;
	}
	/*
	protected Option[] getOption() {
		return opt;
	}*/
	/**
	 * Find the Option with names.
	 * @return option is to be found.
	 */
	protected Option findOption(String name) {
		for(int i=0; i<opt.size(); i++) {
			if(opt.get(i).name.equals(name)) {
				return opt.get(i);
			}
		}
		return null;
	}
	/**
	 * Update data in Option with names.
	 * @param name1 is an existing array element.
	 * @param name2 is another element for name1.
	 */
	protected void updateOptionName(String name1, String name2) {
		for(int i=0; i<opt.size(); i++) {
			if(opt.get(i).name.equals(name1)) {
				opt.get(i).name = name2;
				return;
			}
		}
	}
	/**
	 * Update the price in Option by finding its name.
	 * @param name is an existing array element.
	 * @param newPrice is another new element for name.
	 * @throws AutoException 
	 */
	protected void updateOptionPrice(String name, float newPrice) throws AutoException {
		for(int i=0; i<opt.size(); i++) {
			if(opt.get(i).name.equals(name)) {
				opt.get(i).price = newPrice;
				return;
			}
		}
		throw new AutoException(ErrorType.NO_OPTIONNAME.ordinal(), "Error: The Option name cannot be found");
	}
	/**
	 * Delete data in Option.
	 * @param name is the name of the data to be deleted.
	 */
	protected void deleteOption(String name) {
		for(int i=0; i<opt.size(); i++) {
			if(opt.get(i).name.equals(name)) {
				opt.set(i,null);
				return;
			}
		}
	}
	
	protected class Option implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String name;
		private float price = 0;
		
		protected Option(String name, float price) {
			this.name = name;
			this.price = price;
		}

		protected float getPrice() {
			return price;
		}

		protected void setPrice(float price) {
			this.price = price;
		}

		protected String getName() {
			return name;
		}

		protected void setName(String name) {
			this.name = name;
		}
		/**
		 * Print data.
		 */
		protected void print(){
			System.out.println(name +": $" + price );
		}
	}
}