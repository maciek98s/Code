package lab4.work.com;

public class DepositAccount extends Account implements ValidateAccount
{
	private double intrestRate;
	
	public DepositAccount(String name,String code,String branch,boolean credit,double balance,double rate)
	{
		super(name, code, branch, credit, balance);
		setIntrestRate(rate) ;
	}

	public double getIntrestRate() 
	{
		return intrestRate;
	}

	public void setIntrestRate(double intrestRate) 
	{
		this.intrestRate = intrestRate;
	}
	
	public void withdraw(double money)
	{
		System.out.println("you cannot withdraw from a deposit account ");
	}
	public void getDetails()
	{
		System.out.println("ACcount type Deposit");
		System.out.println("account name is "+getAccountName());
		System.out.println("account balance is equal to "+getAccBalance());
		
	}
	public void valuableAccount()
	{
		System.out.println("Accunt balance is "+getAccBalance());
	
	}


}
