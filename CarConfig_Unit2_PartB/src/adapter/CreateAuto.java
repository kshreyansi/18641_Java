/* @author Shreyansi Kumar
 * 
 */
package adapter;

public interface CreateAuto {
	//An instance of Automobile is created by a method called BuildAuto which is written in the given filename.
	//This method does not  return the Auto instance.
	public void BuildAuto(String filename);
	
	//This function prints the properties of a given Automodel.
	public void printAuto(String Modelname);
	
}