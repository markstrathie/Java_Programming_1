public class Monster 
{
	protected String name;
	protected String monsterBreed;
	protected int monsterLevel;
	protected int maxHealth;
	protected int currentHealth;
	
	public Monster(String name, int level, int maxHealth)
	{
		this.name=name;
		this.monsterLevel=level;
		currentHealth=maxHealth;
		this.maxHealth=maxHealth;
	}

	
	public void levelUp()
	{
		monsterLevel += 1;
		maxHealth += 20;
	}
	
	
	public void rest()
	{
		currentHealth = maxHealth;
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
			System.out.println(name+" is defeated!");
		}
		if (currentHealth >= maxHealth)
		{
			currentHealth = maxHealth;
			System.out.println(name+" is at full health!");
		}
	}

	public boolean isConscious()
	{
		return currentHealth>0;
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
		this.name=name;
	}
}
