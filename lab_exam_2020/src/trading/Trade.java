//a Trade represents a single trade. Each trade has 3 fields:
//1. number of gems involved in the trade
//2. amount of goods involved in the trade
//3. the type of goods involved in the trade

package trading;

import java.util.Objects;

public class Trade {
	
	//fields
	public int gems;
	public int amount;
	public Goods goods;
	
	//constructor
	public Trade(int gems, int amount, Goods goods)
	{
		this.gems = gems;
		this.amount = amount;
		this.goods = goods;
	}
	
	//getters
	public int getGems()
	{
		return gems;
	}

	public int getAmount()
	{
		return amount;
	}
	
	public Goods getGoods()
	{
		return goods;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(amount, gems, goods);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		return amount == other.amount && gems == other.gems && goods == other.goods;
	}
	
	@Override
	public String toString() {
		if (gems == 1)
		{
			return gems + " gem for " + amount + " " + goods;
		} else
		{
			return gems + " gems for " + amount + " " + goods;
		}
	}
	
	//Checks if current trade is included in Trader's list of supported trades.
	//if not, will throw exception.
	//if so, will attempt to execute the trade between trader and citizen
	//depends on if citizen has enough gems
	public void execute(Trader trader, Citizen citizen)
	{
		for (Trade trade : trader.getTrades())
		{
			if (this.equals(trade))
			{
				boolean tradeComplete = citizen.executeTrade(this);
				if (tradeComplete)
				{
					trader.addRandomTrade();
				}
				return;
			}
		}
		throw new IllegalArgumentException("Current trade is not included in the list of trades supported by trader.");
	}

	public static void main(String args[])
	{
		Trade t1 = new Trade(1, 3, Goods.BREAD);
		Citizen c1 = new Citizen(5);
		Trader trader1 = new Trader();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		trader1.addRandomTrade();
		System.out.println(trader1.getTrades());
		System.out.println(c1.getAmount(Goods.BREAD));
		t1.execute(trader1, c1);
		System.out.println(c1.getAmount(Goods.BREAD));
	}

}