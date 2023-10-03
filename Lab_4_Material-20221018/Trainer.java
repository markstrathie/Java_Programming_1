public class Trainer
{
	private Monster[] trainerMonsters=new Monster[6];
	private int numberOfMonsters=0;
	
	public Trainer(Monster starterMonster)
	{
		trainerMonsters[0] = starterMonster;
		numberOfMonsters = 1;
	}

	public void addMonster(Monster newMonster)
	{
		if (numberOfMonsters < 6)
		{
			trainerMonsters[numberOfMonsters] = newMonster;
		}
	}
	
	
	public void restTeam()
	{
		for (Monster i : trainerMonsters)
		{
			i.rest();
		}
	}
	
	
	public void fight(int trainerMonsterNumber, Monster enemyMonster)
	{
		while (trainerMonsters[trainerMonsterNumber-1].currentHealth > 0 && enemyMonster.currentHealth > 0)
		{
			trainerMonsters[trainerMonsterNumber-1].specialAttack();
			enemyMonster.takeDamage(null);
			if (enemyMonster.currentHealth > 0)
			{
				enemyMonster.specialAttack();
				trainerMonsters[trainerMonsterNumber-1].takeDamage(null);
			}
			else
			{
				break;
			}
			if (trainerMonsters[trainerMonsterNumber-1].currentHealth > 0)
			{
				trainerMonsters[trainerMonsterNumber-1].basicAttack();
				enemyMonster.takeDamage(null);
			}
			else
			{
				break;
			}
			if (enemyMonster.currentHealth > 0)
			{
				enemyMonster.basicAttack();
				trainerMonsters[trainerMonsterNumber-1].takeDamage(null);
			}
			else
			{
				break;
			}	
		}
		if (enemyMonster.currentHealth <= 0)
		{
			trainerMonsters[trainerMonsterNumber-1].monsterLevel += 1;
		}
		else if (trainerMonsters[trainerMonsterNumber-1].currentHealth <= 0)
		{
			enemyMonster.monsterLevel += 1;
		}
	}
	
	public void printRoster()
	{
		// Optional task - implementing this can help spot issues in testing
	}
		
	public Monster[] getMonsters()
	{
		return trainerMonsters;
	}

	public int getNumberOfMonsters()
	{
		return numberOfMonsters;
	}
	
	public static void main(String[] args)
	{
		// An example of some of the sorts of tests you might want to run on your code
		// You will need to add in more
		Monster scorchitile =new Scorchitile("Flamey",1,30,15);
		Monster dragonfish =new Dragonfish("Splashy",1,30);
		Monster seedatops = new Seedatops("Vinesy",1,50,2);
		Trainer t = new Trainer (dragonfish);
		t.fight(0, seedatops);
		t.printRoster();
		seedatops.rest();

	}
}