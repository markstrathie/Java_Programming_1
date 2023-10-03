
public class FraudDetection
{
	static boolean suspiciousActivityCheck(CardAccount suspectAccount)
	{
		double maxWithdrawal = CardAccount.getMaxWithdrawal();
		double lastThreeTransactions = CardAccount.getLastThreeTransactions();
		if (lastThreeTransactions < (-maxWithdrawal/2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
