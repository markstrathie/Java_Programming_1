public class CardAccount 
{	
	private int[] accountNumber;
	public double balance =0;
	public static double maxWithdrawal =0;
	public static double lastTransaction1 =0;
	public static double lastTransaction2 =0;
	public static double lastTransaction3 =0;
	public static double lastThreeTransactions =0;
	public double counter =0;
	private String accountHolderName;
	
	public CardAccount(int[] accountNumber, String accountHolderName)
	{
		this.setAccountNumber(accountNumber);
		this.accountHolderName=accountHolderName;
	}

	
	
	public void setAccountNumber(int[] accountNumber) 
	{	
		System.out.println("Checking account:"+outputNumberFormatted(accountNumber));
		int[] batwest = {4,3,3,4,2,1};
		int checkSum=0;
		boolean validBank=true;
		boolean validPersonal=true; 
		
		for(int position=0;position<6;position++)
		{
			if(accountNumber[position]!=batwest[position])
			{
				validBank=false;
			}	
		}
		
		if(validBank)
		{
			System.out.println("The bank managing the account is batwest");
		}
		else
		{
			System.out.println("The bank managing the account is unrecognised");	
		}
		
		for(int position=6;position<15;position++)
		{
			if(accountNumber[position]!=0)
			{
				checkSum++;
			}
			else if(accountNumber[position]<0)
			{
				validBank=false;
			}
		}
		
		if (checkSum!=accountNumber[15])
		{
			validPersonal=false;
			System.out.println("Personal account number not valid");
		}
		else
		{
			System.out.println("Personal account number valid");
		}
		
		if(validPersonal && validBank)
		{
			this.accountNumber = accountNumber;
			System.out.println("Account number valid");
		}
		else
		{
			System.out.println("Account number not valid");
		}
	}
	
	public static String outputNumberFormatted(int[]accountNumber)
	{
		// Modify me for Task 3!
		String number ="";
		for(int position=0;position<16;position++)
		{
			if (position%4==0&&position!=0)
			{
				number+=" ";
			}
			number+=accountNumber[position];
		}
		return number;
	}
	
	public boolean checkName(String name)
	{
		String[]splitCompare = name.split(" ");
		String[]splitAccount=accountHolderName.split(" ");
		
		if (!splitCompare[1].equals(splitAccount[1]))
		{
			return false;
		}
		if (!splitCompare[0].equals(splitAccount[0]))
		{
			if(splitCompare[0].charAt(0)!=splitAccount[0].charAt(0))
			{
				return false;
			}
			if (splitCompare[0].length()!=1)
			{
				return false;
			}
		}	
		return true;
	}
	
	public void processTransaction(char type, double amount)
	{
		++counter;
		switch(type) {
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
				balance-=amount;
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
				System.out.println("Debited:£"+amount);
				System.out.println("Account balance: £"+balance);
				break;
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
	
	public int[] getAccountNumber(){
		return accountNumber;
	}

	public String getAccountHolderName(){
		return accountHolderName;
	}


	public void setAccountHolderName(String accountHolderName){
		this.accountHolderName = accountHolderName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public static double getLastThreeTransactions() {
		lastThreeTransactions = lastTransaction1 + lastTransaction2 + lastTransaction3; 
		return lastThreeTransactions;
	}
	
	public static double getMaxWithdrawal() {
		return maxWithdrawal;
	}
	
	public static void main(String[] args)
	{
		int[] account666 = new int[] {4,3,3,4,2,1,6,7,5,5,4,4,8,0,0,7};
		System.out.println(outputNumberFormatted(account666));
	}

	

}
