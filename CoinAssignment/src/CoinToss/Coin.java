/* @author Shreyansi Kumar
 * Coin Toss Simulator
 */
package CoinToss;

import java.util.Random;

/*This class simulates coin toss randomly
and track the count of heads or tail
*/
public class Coin 
{
	private int headcount;
    private int tailcount;
	private  String sideUp;    
    private static final String HEADS = "heads";
    private static final String TAILS = "tails";

    Coin()
    {
    	this.headcount = 0;
        this.tailcount = 0;
        this.sideUp = HEADS;        
        System.out.println("Side initially facing up before the toss =  " + sideUp);
    }
/* Toss coin randomly */
    
    
    public void toss()
    {
        Random rand = new Random();
        int sideup = rand.nextInt(2);
        if (sideup == 1) 
            sideUp = HEADS;
        else 
            sideUp = TAILS;    
    }

    /* display the value of coin facing up */
    public String getSideUp()
    {
        System.out.println(sideUp);
        return sideUp;
    }

    /* Track no. of heads and tails and store the number */
    
    public void calculateCount()
    {
    if (getSideUp().equals(HEADS)) 
        this.headcount++;
    else
        this.tailcount++;
    }

    /* Get total no. of heads and tails */
    
    public int getHeadCount()
    {
        return this.headcount;
    }

    public int getTailCount()
    {
        return this.tailcount;
    }

    
}