/* 
 * @author Shreyansi Kumar
 */
package driver;

import model.Automotive;
import util.FileIO;



public class Driver {
	public static void main(String [] args) {
		
		FileIO file = new FileIO();
		//Create Automobile Object from a file.
		Automotive auto = file.buildAutomotiveObject("C:/Users/Shreyanshi/Desktop/FordZTW.txt");		
		//Attributes before serialization
        System.out.println("Before serialization!\n");
		auto.print();
		
		
        FileIO fio = new FileIO();
      //Serialize
        Automotive FordZTW = fio.serializeAutomotive(auto);
        System.out.println("After Serialization !\n");
       // Print new attributes
        FordZTW.print();
        
        
        /**
         * Finding
         */
        System.out.println("Find Toyota-- Negative Test Case \n");
        FordZTW.findOptionSet("Automatic Steering");
        FordZTW.findOption("Toyota ");        
        FordZTW.print();
        System.out.println("Finished Finding");
        /**
         * Updating
         */
        System.out.println("\nNow update Hybrid, $0.0 of classic and Fuel Efficiency!-- Negative Test Case\n");
        FordZTW.updateOption("Hybrid ", "classic");
        FordZTW.updateOption("classic ", 400);
		FordZTW.updateOptionSet("Fuel Efficiency", "Transmission Control");
		FordZTW.print();
		System.out.println("Finished Updating!\n");
		 /**
         * Deleting
         */
		System.out.println("\nNow delete Toyota and Fuel Efficiency!-- Negative Test Case\n");
        FordZTW.deleteOption("Fuel Efficiency ");
		FordZTW.deleteOptionSet("Toyota");
		FordZTW.print();
		System.out.println("Finished Deleting!\n"); 
	}
}