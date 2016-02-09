package driver;
/* @author Shreyansi Kumar
 * 
 */

import adapter.BuildAuto;

public class DriverUnit2 {
	public static void main(String[] args) {
		String fileName = "C:/Users/Shreyanshi/Desktop/FordZTW.txt";
		String modelName = "FordZTW";
		
		BuildAuto au = new BuildAuto();
		//System.out.println("in the driver\n");
		au.BuildAuto(fileName);
		au.printAuto(modelName);
		
		System.out.println("Before Updating:\n");
	
		au.updateOptionPrice("FordZTW", "Power Moonroof", "present", 999);
		au.printAuto(modelName);
		System.out.println("Finished Updating!\n");
		
		System.out.println("Next do Choice Setting:\n");
		au.setOptionhoice("Color", "Fort Knox Gold Clearcoat Metallic");
		au.setOptionhoice("Transmission", "standard");
		au.setOptionhoice("Brakes/Traction Control", "ABS");
		au.setOptionhoice("Side Impact Air Bags", "present");
		au.setOptionhoice("Power Moonroof", "not present");
		au.printChoice();
		System.out.println("Finished Setting Choice!\n");
		
		float price = au.getTotalPrice();
		System.out.println("The total price is " + price);

	}
}
