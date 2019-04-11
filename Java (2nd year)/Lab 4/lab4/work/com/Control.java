package lab4.work.com;

public class Control {

	public static void main(String[] args)
	{
		Account ac1 = new Account("Jamie","89D","AIB",true,12430);
		DepositAccount dp1 = new DepositAccount("John","565G","BOI",true,28400,4);
		CurrentAccount ca1 = new CurrentAccount("Barry","6969696","Ulster",true,1010,1);
		
		ac1.deposit(200.4);
		ac1.withdraw(50);
		
		dp1.withdraw(50);
		
		ca1.withdraw(901);
		ca1.checkCredit();
		
		ca1.valuableAccount();
		ca1.getDetails();
		
		//System.out.println(ca1.getAccountNumber());
		

	}

}
