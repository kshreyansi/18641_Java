/* @author Shreyansi Kumar
 * 
 */
package exception;


import java.util.Scanner;

@SuppressWarnings("resource")

public class Fix1to5 implements FixAuto {
	public String fix(int errNum) {
		switch(errNum) {
		case 0:
			return fix1();
		case 1:
			return fix2();
		case 2:
			return fix3();
		case 3:
			return fix4();
		case 4:
			return fix5();
		default:
			System.out.println("Unknown error!");
			break;
		}
		return null;
	}
	
	public String fix1() {
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		System.out.println("Give the correct file directory:"); 
		String fileName = s.nextLine();
		System.out.println();
		return fileName;
	}
	
	public String fix2() {
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		System.out.println("Give a base price:"); 
		String basePrice = s.nextLine();
		System.out.println();
		return basePrice;
	}
	
	public String fix3() {
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		System.out.println("Give a name for OptionSet:"); 
		String optionSetName = s.nextLine();
		System.out.println();
		return optionSetName;
	}
	
	public String fix4() {
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		System.out.println("Give a name for Option:"); 
		String optionName = s.nextLine();
		System.out.println();
		return optionName;
	}
	
	public String fix5() {
		Scanner s = new Scanner(System.in);
		s.useDelimiter("\n");
		System.out.println("Give input of the missing price of the Option:"); 
		String optionPrice = s.nextLine();
		System.out.println();
		return optionPrice;
	}
}