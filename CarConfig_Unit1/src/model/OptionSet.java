/**
 * @author Shreyansi Kumar
 */
package model;

import java.io.Serializable;

public class OptionSet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Option[] opt;
	/**
	 * OptionSet object initialised.
	 */
	protected OptionSet(String name, int optionSetSize) {
		this.name = name; 
		opt = new Option[optionSetSize]; 
	}
	/**
	 * Option object initialised
	 */
	protected void setOption(int num, String name, float price) {
		opt[num] = new Option(name);
		opt[num].price = price;
	}
	/**
	 * Print data
	 */
	protected void print(){
		System.out.println(name+": " );
		for(int i = 0;i<opt.length;i++){
			if(opt[i]!=null) {
			opt[i].print();
			}
		}
		System.out.println("");
	}

	protected void setName(String name) {
		this.name = name;
	}
	
	protected String getName() {
		return name;
	}
	/**
	 * Find the Option with names.
	 * @param name is a String that is searched for.
	 * @return option is to be matched and printed.
	 */
	protected Option findOption(String name) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].name.equals(name)) {
				System.out.println("Output is " + opt[i].getName() + " and price is $" + opt[i].price + ".");
				return opt[i];
			}
		}
		return null;
	}
	/**
	 * Update name data in Options.
	 * @param name1 is existing element in the array.
	 * @param name2 is a new element and will replace name1.
	 */
	protected void updateOption(String name1, String name2) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].name.equals(name1)) {
				opt[i].name = name2;
				return;
			}
		}
	}
	/**
	 * Update price data in Option for a name
	 * @param name is existing element in the array.
	 * @param newPrice another element name.
	 */
	protected void updateOption(String name, float newPrice) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].name.equals(name)) {
				opt[i].price = newPrice;
				return;
			}
		}
	}
	/**
	 * Delete Option data one by one
	 * @param name is the name of the data to be deleted.
	 */
	protected void deleteOption(String name) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].name.equals(name)) {
				opt[i] = null;
				return;
			}
		}
	}
	
	public class Option implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String name;
		private float price = 0;
		
		protected Option(String name) {
			this.name = name;
		}

		protected String getName() {
			return name;
		}

		protected void setName(String name) {
			this.name = name;
		}
		
		protected void print(){
			System.out.println(name +": $" + price );
		}
	}
}
