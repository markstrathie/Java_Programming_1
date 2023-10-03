import java.util.Arrays;

public class CardAccount {
	int[] accountNumber;
	double balance;
	String accountHolderName;

	public void setAccountNumber(int[] accountNumber) {
		System.out.print("Checking account: ");
		for (int digit : accountNumber) {
			System.out.print(digit);
		}
		System.out.println();

		// bank arrays
		int[] batwest = new int[] { 4, 3, 3, 4, 2, 1 };

		// checking bank identity
		int[] bankNo = Arrays.copyOfRange(accountNumber, 0, 6);
		boolean retval = Arrays.equals(bankNo, batwest);
		if (retval == true) {
			System.out.println("The bank managing the account is batwest");
		} else {
			System.out.println("The bank managing the account is unrecognised");
		}

		// checking personal account no.
		int[] personalNo = Arrays.copyOfRange(accountNumber, 6, 15);
		int checksum = accountNumber[15];
		int counter = 0;
		boolean personalValid = true;
		for (int digit : personalNo) {
			if (digit != 0) {
				counter++;
			}
			if (digit < 0 || digit > 9) {
				personalValid = false;
			}
		}
		if (checksum == counter && personalValid) {
			System.out.println("Personal account number valid");
		} else {
			System.out.println("Personal account number not valid");
		}

		// checking account no.
		if (personalValid && retval) {
			System.out.println("Account number valid");
			this.accountNumber = accountNumber;
		} else {
			System.out.println("Account number not valid");
			this.accountNumber = null;
		}
	}

	public void processTransaction(char type, double amount) {
		switch (type) {

		case 'c':
			balance += amount;
			System.out.println("Credited: £" + amount);
			System.out.println("Account balance: " + (balance));
			break;

		case 'd':
			balance -= amount;
			System.out.println("Debited: £" + amount);
			System.out.println("Account balance: " + (balance));
			break;

		case 'f':
			System.out.println("Transaction has been flagged so no action taken.");
			System.out.println("Account balance: £" + balance);
			break;
		}
	}

	public boolean checkName(String name) {
		String trueName = (getAccountHolderName().toLowerCase());
		String testName = name.toLowerCase();
		boolean retval = trueName.equals(testName);
		String[] trueNameSplit = trueName.split(" ");
		String[] testNameSplit = testName.split(" ");
		String trueSurname = trueNameSplit[1];
		String testSurname = testNameSplit[1];
		boolean retval2 = trueSurname.equals(testSurname);
		char trueInitial = trueName.charAt(0);
		char testInitial = testName.charAt(0);

		if (retval) {
			return true;
		} else if (retval2 && testNameSplit[0].length() == 1 && testInitial == trueInitial) {
			return true;
		} else {
			return false;
		}
	}

	public int[] getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	CardAccount(int[] accountNumber, String accountHolderName) {
		setAccountNumber(accountNumber);
		this.accountHolderName = accountHolderName;
		this.balance = 0;
	}

	public static void main(String[] args) {
		CardAccount c = new CardAccount(new int[] { 4, 3, 3, 4, 2, 1, 6, 7, 5, 5, 4, 4, 8, 0, 0, 7 }, "mr egg");
		System.out.println(c.getAccountHolderName());
		System.out.println(c.getBalance());
		System.out.println(c.getAccountNumber());
		c.processTransaction('c', 20);
		c.processTransaction('d', 19);
		c.processTransaction('f', 1);
		System.out.println(c.checkName("m EGG"));
	}
}