/*
 * @author Shreyansi Kumar
 */
package adapter;

import model.Automobile;
import util.FileIO;

public abstract class ProxyAutomobile implements CreateAuto, UpdateAuto {
	private Automobile a1;

	@Override
	public void BuildAuto(String filename) {
		FileIO fo = new FileIO();
		a1 = fo.buildAutomotiveObject(filename);
	}

	@Override
	public void printAuto(String Modelname) {
		if(a1.getName().equals(Modelname)) {
			a1.print();
		}
		else
			System.out.println(Modelname + " cannot be found!");
	}
	
	@Override
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName) {
		if(a1.getName().equals(Modelname)) {
			a1.updateOptionSet(OptionSetname, newName);
		}
		else
			System.out.println(Modelname + " cannot be found");
	}

	@Override
	public void updateOptionPrice(String Modelname, String Optionname, String Option, float newprice) {
		if(a1.getName().equals(Modelname)) {
			a1.updateOption(Optionname, Option, newprice);
		}
		else
			System.out.println(Modelname + " cannot be found");
	}
}