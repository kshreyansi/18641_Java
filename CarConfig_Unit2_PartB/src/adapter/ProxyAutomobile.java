/* @author Shreyansi Kumar
 * 
 */
package adapter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import exception.AutoException;
import exception.ErrorType;
import model.Automobile;
import util.FileIO;

public abstract class ProxyAutomobile implements CreateAuto, UpdateAuto {
	private Automobile a1;
	private LinkedHashMap <Integer,Automobile>lHashMap = new LinkedHashMap<Integer,Automobile>();

	@Override
	
	public void BuildAuto(String fileName) {
		FileIO fo = new FileIO();
		a1 = fo.buildAutomotiveObject(fileName);
		lHashMap.put(lHashMap.size(), a1);
		//System.out.println("After proxy class\n");
	}

	@Override
	public void printAuto(String Modelname) {
		try {
			Iterator<Entry<Integer, Automobile>> lit = lHashMap.entrySet().iterator();
			while(lit.hasNext()) {
				Entry<Integer, Automobile> e = (Entry<Integer, Automobile>) lit.next();
				if(e.getValue().getModel().equals(Modelname)) {
					e.getValue().print();
					return;
				}
				throw new AutoException(ErrorType.NO_MODELNAME.ordinal(), "Error: Model cannot be found!");
			}
		} catch(AutoException ae) {
			AutoException.log(ae);
			Modelname = ae.fix(ErrorType.NO_MODELNAME.ordinal());
			printAuto(Modelname);
		}
	}

	
	@Override
	public void updateOptionSetName(String Modelname, String OptionSetname, String newName) {
		try {
			Iterator<Entry<Integer, Automobile>> lit = lHashMap.entrySet().iterator();
			while(lit.hasNext()) {
				Entry<Integer, Automobile> e = (Entry<Integer, Automobile>) lit.next();
				if(e.getValue().getModel().equals(Modelname)) {
					e.getValue().updateOptionSet(OptionSetname, newName);
					return;
				}
				throw new AutoException(ErrorType.NO_OPTIONSETNAME.ordinal(), "Error: OptionSet cannot be found!");
			}
		} catch(AutoException ae) {
			AutoException.log(ae);
			OptionSetname = ae.fix(ErrorType.NO_OPTIONSETNAME.ordinal());
			updateOptionSetName(Modelname, OptionSetname, newName);
		}
	}

	
	@Override
	public void updateOptionPrice(String Modelname, String Optionname, String Option, float newprice) {
		try {
			Iterator<Entry<Integer, Automobile>> lit = lHashMap.entrySet().iterator();
			while(lit.hasNext()) {
				Entry<Integer, Automobile> e = (Entry<Integer, Automobile>) lit.next();
				if(e.getValue().getModel().equals(Modelname)) {
					e.getValue().updateOptionPrice(Optionname, Option, newprice);
					return;
				}
				throw new AutoException(ErrorType.NO_OPTIONNAME.ordinal(), "Error: Option cannot be found!");
			}
		} catch(AutoException ae) {
			AutoException.log(ae);
			Option = ae.fix(ErrorType.NO_OPTIONNAME.ordinal());
			updateOptionPrice(Modelname, Optionname, Option, newprice);
		}
	}
	
	public void setOptionhoice(String setName, String optionName) {
		a1.setOptionChoice(setName, optionName);
	}
	
	public void printChoice() {
		a1.printChoice();
	}
	
	public float getTotalPrice() {
		return a1.getTotalPrice(); 
	}
	
	public float getOptionChoicePrice(String setName) {
		return a1.getOptionChoicePrice(setName);
	}
}