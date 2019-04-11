package com.lab3.test;

public class ComissionEmployee extends Employee 
{
	
	double commissionEarned;
	
	public ComissionEmployee(String name,String sur,int number,double salary,double comission)
	{
			super(name,sur,number,salary);
			commissionEarned = comission;
			
	}
	
	public double calculatePay()
	{
		return (getAnnualSalary()/12)+commissionEarned;
	}
	
		public String toString()
		{
			return super.toString()+"\n Their Annual Salary is: €"+getAnnualSalary()+".";
		}

}
