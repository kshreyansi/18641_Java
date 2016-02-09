/**
 * @author Shreyansi Kumar
*/
package model;

import java.io.Serializable;

import exception.AutoException;
import exception.ErrorType;

public class OptionSet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Option[] opt;
	/**
	 * OptionSet object initialised
	 */
	protected OptionSet(String name, int optionSetSize) {
		this.name = name; 
		opt = new Option[optionSetSize]; 
	}
	/**
	 * Option object initialised
	 */
	protected void setOption(int n, String name, float price) {
		try {
			if(name.equals("") || name.equals(" ")) {
				throw new AutoException(ErrorType.NO_OPTIONNAME.ordinal(), "Error: The Option name cannot be found!");
			}
		} catch(AutoException ae) {
			name = ae.fix(ErrorType.NO_OPTIONNAME.ordinal());
		} finally {
		opt[n] = new Option(name);
		opt[n].price = price;
		}
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
	
	protected Option[] getOption() {
		return opt;
	}
	/**
	 * Find the Option with names.
	 * @return option is to be searched.
	 */
	protected Option findOption(String name) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].name.equals(name)) {
				System.out.println("The result is " + opt[i].getName() + " and $" + opt[i].price + ".");
				return opt[i];
			}
		}
		return null;
	}
	/**
	 * Update Option with names.
	 * @param name1 is an existing array element.
	 * @param name2 is another element for name1.
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
	 * Update the price in Option by finding its name.
	 * @param name is an existing array element
	 * @param newPrice is another element for name.
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
	 * Delete data in Option.
	 * @param name is the data to be deleted.
	 */
	protected void deleteOption(String name) {
		for(int i=0; i<opt.length; i++) {
			if(opt[i].name.equals(name)) {
				opt[i] = null;
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
		
		protected Option(String name) {
			this.name = name;
		}

		protected String getName() {
			return name;
		}

		protected void setName(String name) {
			this.name = name;
		}
		/**
		 * Print formatted data.
		 */
		protected void print(){
			System.out.println(name +": $" + price );
		}
	}
}