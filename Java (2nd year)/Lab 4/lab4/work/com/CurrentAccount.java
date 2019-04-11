package lab4.work.com;

public class CurrentAccount extends Account implements ValidateAccount
{

	private double penaltyAmmount;
	
	
	public CurrentAccount(String name, String code, String branch, boolean credit, double balance,double penalty)
	{
		super(name,code,branch,credit,balance);
		penaltyAmmount = penalty;
	}
	
	public void withdraw(double money)
	{
		if( getAccBalance() < money)
		{
			System.out.println("NO");
		}
		else
		{
			double newbalance; 
			newbalance = getAccBalance() - money;
			setAccBalance(newbalance);
			System.out.println("account balance is "+getAccBalance());
		}
		
	}
	
	public void checkCredit()
	{
		if(getAccBalance() <= 0)
		{
			setInCredit(false);
		}
		if(getInCredit() == false)
		{
			System.out.println("Your account is not in credit");
		}
		else
		{
			System.out.println("Your account is in credit");
		}
		if(getAccBalance() < 100 && getAccBalance() > 0)
		{
			String warningMessage;
			warningMessage = "WARNING your balance is going low ";
			checkCredit(warningMessage);
		}
		
	}
	
	public void checkCredit(String Message)
	{
		System.out.println(Message);
	}
	
	public void getDetails()
	{
		System.out.println("ACcount type Current");
		System.out.println("THe account name is "+getAccountName());
		System.out.println("the account balance is equal to "+getAccBalance());
	}
	public void valuableAccount()
	{
		System.out.println("Accunt balance is "+getAccBalance());
	
	}
	
}
