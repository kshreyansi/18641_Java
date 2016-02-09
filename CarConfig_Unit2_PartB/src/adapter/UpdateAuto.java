/* @author Shreyansi Kumar
 * 
 */
package adapter;

public interface UpdateAuto {
	// For a given OptionSet, this function searches the Model and sets the name of OptionSet to 
	//newName.
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName);
	
	//For a given OptionSet and Option name, this function searches the Model  and sets the price to 
	//newPrice.
	public void updateOptionPrice(String Modelname, String Optionname, String Option, float newprice);
	
}