// @author Shreyansi Kumar//

package CoinToss;

/* This is a simulation class that tests the Coin class */

public class Simulation {
	public static void main(String[] args)
    {
        Coin coin = new Coin();
        
        for (int i = 1; i <= 20; i++) 
        {
            coin.toss();
            coin.calculateCount();
        }
        System.out.println("Number of heads = " + coin.getHeadCount() + " Number of tails =  " + coin.getTailCount());
    }

}
