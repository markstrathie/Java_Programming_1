//represents a citizen in the game.
//Each citizen has a certain number of gems that they can use to trade.
//a citizen starts with an empty inventory that holds good types and their amounts when they make trades.

package trading;

import java.util.ArrayList;
import java.util.List;

public class Citizen {
	
	//fields
	public int gems;
	public ArrayList<ArrayList<Object>> inventory = new ArrayList<>();
	
	//constructor
	public Citizen(int gems)
	{
		this.gems = gems;
	}

	//getters
	public int getGems() {
		return gems;
	}

	//returns current amount of specified goods type in inventory.
	//if citizen doesn't have any goods of that type will return 0.
	public int getAmount(Goods goods) {
		for (ArrayList<Object> obj : inventory)
		{
			if (obj.get(1) == goods)
			{
				int x = (Integer)obj.get(0);
				return x;
			}
			else
			{
				return 0;
			}
		}
		return 0;
	}
	
	//checks if citizen has enough gems for trade
	//if not, returns false.
	//if so, will minus gems accordingly and update inventory with goods and amount, and return true.
	public boolean executeTrade(Trade trade)
	{
		if (gems >= trade.getGems())
		{
			gems -= trade.getGems();
			if (getAmount(trade.getGoods()) != 0)
			{
				for (ArrayList<Object> obj : inventory)
				{
					if (obj.get(1) == trade.getGoods())
					{
						int x = (Integer)obj.get(0);
						x += trade.getAmount();
						obj.set(0, x);
						return true;
					}
					//error checking
					else
					{
						System.out.println("Error: Goods already in inventory but can't add more.");
						return false;
					}
				}
			}
			else
			{
				ArrayList<Object> obj = new ArrayList<>();
				obj.add(trade.getAmount());
				obj.add(trade.getGoods());
				inventory.add(obj);
				return true;
			}
		}
		else
		{
			return false;
		}
		return false;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
