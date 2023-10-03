
public class Bank
{
	private int[] accountOne = new int[]{4,3,3,4,2,1,6,7,5,5,4,4,8,0,0,7};
	private int[] accountTwo = new int[]{4,3,3,4,2,1,6,7,5,5,4,4,8,5,3,9};
	private int[] accountThree = new int[]{4,3,3,4,2,1,0,7,0,5,4,4,8,0,0,5};
	private String nameOne = "Alice Smith";
	private String nameTwo = "Osian Jones";
	private String nameThree = "Claire Bevan";
	public CardAccount[] cardAccounts;

	public Bank()
	{
		CardAccount account1 = new CardAccount(accountOne,nameOne);
		CardAccount account2 = new CardAccount(accountTwo,nameTwo);
		CardAccount account3 = new CardAccount(accountThree,nameThree);
		cardAccounts = new CardAccount[] {account1,account2,account3};
	}

	public CardAccount[] getCardAccounts()
	{
		return cardAccounts;
	}
	
	public CardAccount handleTransaction(int[]accountNumber, String name, double amount, char type)
	{
		for(CardAccount i : cardAccounts)
		{
			if (i.getAccountNumber() == accountNumber)
			{
				if (i.checkName(name))
				{
					i.processTransaction(type, amount);
					return i;
				} else
				{
					System.out.println("Incorrect name");
					return i;
				}
			} else
			{
				System.out.println("No matching account found");
				return null;
			}
		}
		return null;
	}

	public static void main(String[] args)
	{
		Bank bank1 = new Bank();	
		System.out.println(bank1.getCardAccounts());
	}
}
