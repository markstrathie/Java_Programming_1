package game_utility;
import monsters.Monster;
import monsters.Scorchitile;

public class MonsterMaker {
	
	private static final int SCORCHITILE = 0;
	private static final int TOTAL_NUMBER_OF_BREEDS=1;
	
	
	public static Monster makeRandomMonster(String name, int level)
	{			
		int monster = randomMonster(0,TOTAL_NUMBER_OF_BREEDS-1);
		switch (monster) {
		case SCORCHITILE:
			return new Scorchitile(name,level,level*10,level*10+5);
		default:
			return new Scorchitile("Should be unreachable",level,level*10,level*10+5);
		}	
	}
	
	public static Monster makeRandomWildMonster(int level)
	{
		int monster = randomMonster(0,TOTAL_NUMBER_OF_BREEDS-1);
		switch (monster) {
		case SCORCHITILE:
			System.out.println("There's a strange glow behind that rock....");
			return new Scorchitile("Wild Scorchitile",level,level*10,level*10+5);
		default:
			return new Scorchitile("Should be unreachable",level,level*10,level*10+5);
		}	
	}
	
	private static int randomMonster(int lowerBound, int upperBound) 
	{
		return (int)(Math.random()*(upperBound-lowerBound+1)+lowerBound); 
	}

	

}
