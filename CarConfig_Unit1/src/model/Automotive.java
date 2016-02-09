/**
 * author @Shreyansi Kumar 
 */
package model;

import java.io.Serializable;

import model.OptionSet.Option;

public class Automotive implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private float basePrice;
	private OptionSet opt[];
	
	public Automotive() {
	}
	/**
	 * Automotive object initialized with values
	 */
	public Automotive(String name, float basePrice, int size) {
		this.name = name;
		this.basePrice = basePrice;
		this.opt = new OptionSet[size];
	}
	/**
	 * Method to initialize the object OptionSet with values
	 */
	public void setOptionSet(int opset_num, String name, int optionSetSize) {
		opt[opset_num] = new OptionSet(name, optionSetSize);
	}
	/**
	 * Initialize an object of Option.
	 */
	public void setOption(int opset_num, int num_opt, String name, float price) {
		opt[opset_num].setOption(num_opt, name, price);
	}
	
	public OptionSet getOptionSet(int n) {
		return opt[n];
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
	 * 
	 */
	public void print() {
		System.out.println("Model: " + name + "\nBase Price: $" + basePrice + "\n");
		for (int i = 0; i < opt.length; i++) {
			if (opt[i] != null)
				opt[i].print();
		}
		System.out.println("");
	}
	/**
	 * Search OptionSet with names.
     * @return opset[i] is to be found.
	 */
	public OptionSet findOptionSet(String name) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].getName().equals(name)) {
				 System.out.println("Output is " + opt[i].getName() + ".");
				 return opt[i];
			}
		}
		System.out.println(name + "  cannot found!");
		return null;
	}
	/**
	 * Search Option with names.
	 * @return option is  to be found.
	 */
	public Option findOption(String name) {
		for(int i=0; i<opt.length;i++) {
			Option option = opt[i].findOption(name);
			if(option != null) {
				return option;
			}
		}
		System.out.println(name + " cannot be found!");
		return null;
	}
	/**
	 * Update data in OptionSet with names.
	 * @param name1 is an existing element in the array.
	 * @param name2 is a new element for name1.
	 */
	public void updateOptionSet(String name1, String name2) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].getName().equals(name1)) {
				opt[i].setName(name2);
				return;
			}
		}
		System.out.println(name1 + " cannot be found!");
	}
	/**
	 * Update data in Option with names.
	 * @param name1 is an element in the array.
	 * @param name2 is a new element for name1.
	 */
	public void updateOption(String name1, String name2) {
		for(int i=0; i<opt.length; i++) {
			Option option = opt[i].findOption(name1);
			if(option != null) {
				opt[i].updateOption(name1, name2);
				return;
			}
		}
		System.out.println(name1 + " cannot be found!");
	}
	/**
	 * Update the price in Option by finding its name.
	 * @param name is an existing element in the array.
	 * @param newPrice is a new element for name.
	 */
	public void updateOption(String name, float newPrice) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].findOption(name) != null) {
				opt[i].updateOption(name, newPrice);
				return;
			}
		}
		System.out.println(name + " cannot be found!");
	}
	/**
	 * Delete data one by one in OptionSet.
	 * @param name is the name of the data to be deleted.
	 */
	public void deleteOptionSet(String name) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].getName().equals(name)) {
				opt[i] = null;
				return;
			}
		}
		System.out.println(name + " cannot be found!");
	}
	/**
	 * Delete data one by one in Option.
	 * @param name is the name of the data to be deleted.
	 */
	public void deleteOption(String name) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].findOption(name) != null) {
				opt[i].deleteOption(name);
				return;
			}
		}
		System.out.println(name + " cannot be found!");
	}
}