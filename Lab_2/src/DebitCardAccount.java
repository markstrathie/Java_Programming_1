
public class DebitCardAccount extends CardAccount
{
	public DebitCardAccount(int[] accountNumber, String accountHolderName)
	{
		super(accountNumber, accountHolderName);
	}
	
	public void processTransaction(char type, double amount)
	{
		++counter;
		switch(type)
		{
		case 'c':
			balance+=amount;
			if (balance > maxWithdrawal)
			{
				maxWithdrawal = balance;
			}
			if (counter == 1)
			{
				lastTransaction1 = amount;
			}
			else if (counter == 2)
			{
				lastTransaction2 = amount;
			}
			else if (counter == 3)
			{
				lastTransaction3 = amount;
			}
			else
			{
				counter = 1;
				lastTransaction1 = amount;
			}
			System.out.println("Credited:£"+amount);
			System.out.println("Account balance: £"+balance);
			break;
		case 'd':
			if (balance - amount < 0)
			{
				System.out.println("Transaction declined – debit account cannot go below 0");
				if (counter == 1)
				{
					lastTransaction1 = 0;
				}
				else if (counter == 2)
				{
					lastTransaction2 = 0;
				}
				else if (counter == 3)
				{
					lastTransaction3 = 0;
				}
				else
				{
					counter = 1;
					lastTransaction1 = 0;
				}
				break;
			}
			else
			{
				if (counter == 1)
				{
					lastTransaction1 = -amount;
				}
				else if (counter == 2)
				{
					lastTransaction2 = -amount;
				}
				else if (counter == 3)
				{
					lastTransaction3 = -amount;
				}
				else
				{
					counter = 1;
					lastTransaction1 = -amount;
				}
				balance-=amount;
				System.out.println("Debited:£"+amount);
				System.out.println("Account balance: £"+balance);
				break;
			}
		case 'f':
			if (counter == 1)
			{
				lastTransaction1 = 0;
			}
			else if (counter == 2)
			{
				lastTransaction2 = 0;
			}
			else if (counter == 3)
			{
				lastTransaction3 = 0;
			}
			else
			{
				counter = 1;
				lastTransaction1 = 0;
			}
			System.out.println("Account has been flagged so no action taken.");
			System.out.println("Account balance: £"+balance);	
			break;
		}
	}
}
