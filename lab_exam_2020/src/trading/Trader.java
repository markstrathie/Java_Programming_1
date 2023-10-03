//Represents a Trader in the game. Creates a trader starting with 1 random trade.

package trading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trader {
	
	//fields
	List<Trade> trades = new ArrayList<>();
		
	//constructor
	public Trader()
	{
		addRandomTrade();
	}
	
	//full list of trades supported by the trader.
	public List<Trade> getTrades()
	{
		return trades;
	}
	
	//add a new random trade to the trader's list of trades.
	//each trade has gems and goods amount values between 1-5.
	//type of goods will be random from goods enum.
	public void addRandomTrade()
	{
		Random rand = new Random();
		int gems = rand.nextInt(5) + 1;
		int amount = rand.nextInt(5) + 1;
		Goods goods = Goods.values()[rand.nextInt(Goods.values().length)];
		Trade trade = new Trade(gems, amount, goods);
		trades.add(trade);
	}

}
