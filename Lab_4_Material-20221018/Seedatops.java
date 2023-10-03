
public class Seedatops extends PlantFamily
{
	// Task 2_7 and 2_8 are fix my constructor and add a method to me 
	public Seedatops(String name, int level, int health, int maxCharges)
	{	
		super(name, level, health, maxCharges);
	}
	
	public Damage basicAttack()
	{
		return new Damage(DamageType.NORMAL, monsterLevel * 10);
		takeDamage(new Damage(DamageType.NORMAL, monsterLevel * -5));
	}
}
