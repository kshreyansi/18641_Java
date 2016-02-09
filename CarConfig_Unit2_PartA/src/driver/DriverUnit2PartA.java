/*
 * @author Shreyansi Kumar
 */
package driver;

import adapter.BuildAuto;

public class DriverUnit2PartA {
	public static void main(String[] args) {
		BuildAuto au = new BuildAuto();
		
		au.BuildAuto("C:/Users/Shreyanshi/Desktop/FordZTW.txt");
		au.printAuto("FordZTW");
		au.updateOptionSetName("FordZTW", "Side Impact Air Bags", "Air Bags");
		au.updateOptionPrice("FordZTW", "Air Bags","present ", 99);
		System.out.println("Finished updating \"Side Impact Air Bags\":\n");
		au.printAuto("FordZTW");
	}
}
