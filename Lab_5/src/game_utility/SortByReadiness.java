package game_utility;

import java.util.Comparator;

import monsters.Monster;

public class SortByReadiness implements Comparator<Monster>
{
	public int compare(Monster m1, Monster m2)
	{
		int m1Health = m1.getHealth();
		
		return m1.getName().compareTo(m2.getName());
	}
}
