package monsters;

import game_utility.Damage;

public class Monster 
{
	protected String name;
	protected String monsterBreed;
	protected int monsterLevel;
	protected int maxHealth;
	protected int currentHealth;
	
	protected final static double RESIST_DAMAGE=0.5;
	protected final static double VULNERABLE_DAMAGE=2;
	protected final static int LEVELUP_HEALTH_GAIN=20;
	
	
	public Monster(String name, int level, int maxHealth)
	{
		this.name=name;
		this.monsterLevel=level;
		currentHealth=maxHealth;
		this.maxHealth=maxHealth;
	}
	
	public void rest()
	{
		currentHealth=maxHealth;
	}
	
	public void levelUp()
	{
		monsterLevel++;
		maxHealth+=LEVELUP_HEALTH_GAIN;
		System.out.print("--"+name+" is now a level "+monsterLevel+" "+monsterBreed+" and they have " +maxHealth+" max health.");
	}
	
	
	public Damage basicAttack()
	{
		return null;
	}
	
	public Damage specialAttack()
	{
		return null;
	}

	public void takeDamage(Damage damage)
	{
		currentHealth-=damage.getAmount();
		System.out.println(name+" takes "+damage.getAmount()+" "+damage.getType()+" damage.");
		if (currentHealth <= 0)
		{
			currentHealth = 0;
			System.out.println(name+" is defeated");
		}
		if (currentHealth >= maxHealth)
		{
			currentHealth = maxHealth;
			System.out.println(name+" is at full health!");
		}
	}

	public boolean isConscious()
	{
		if(currentHealth<=0)
		{
			return false;
		}
		else return true;
	}
	
	public String makeMonsterDescription()
	{
		return (name.toUpperCase() + " a level "+monsterLevel + " "+monsterBreed);
	}

	
	public String getName()
	{
		return name;
	}

	public String getMonsterBreed()
	{
		return monsterBreed;
	}

	public int getMonsterLevel()
	{
		return monsterLevel;
	}

	public int getHealth()
	{
		return currentHealth;
	}

	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public void setName(String name)
	{
		this.name =name;
	}
}
