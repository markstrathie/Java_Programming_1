public class PlantFamily extends Monster
{
	protected int charges;
	private int maxCharges;

	public PlantFamily(String name, int level, int health, int maxCharges)
	{
		super(name, level, health);
		charges = maxCharges;
		this.maxCharges=maxCharges;
		
	}
	public void levelUp()
	{
		maxCharges += 1;
	}

	public void takeDamage(Damage damage)
	{
		switch (damage.getType())
		{
		case FIRE:
			super.takeDamage(new Damage(damage.getType(),(int)(damage.getAmount()*2)));
			break;
		case PLANT:
			super.takeDamage(new Damage(damage.getType(),(int)(damage.getAmount()*0.5)));
			break;
		default:
			super.takeDamage(damage);
		}
	}
	
	public Damage specialAttack()
	{
		if (charges > 0)
		{
			System.out.println(name + " throws some magic mushrooms!");
			charges -= 1;
			return new Damage(DamageType.PLANT, monsterLevel * 10);
		}
		else
		{
			System.out.println(name + " has run out of mushrooms :(");
			return new Damage(DamageType.PLANT, 0);
		}
	}
	
	public Damage basicAttack()
	{
		return new Damage(DamageType.NORMAL, monsterLevel * 10);
	}

	public void rest()
	{
		charges = maxCharges;
	}

	public String makeMonsterDescription()
	{
		return super.makeMonsterDescription() + ", a plant monster with " + charges + "/" + maxCharges + " charges and "
				+ currentHealth + "/" + maxHealth + " health";
	}

}
