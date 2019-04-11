package com.lab3.test;

public class Employee
{
	private String firstName;
	private String surName;
	private int staffNumber;
	private double annualSalary;
	
	public Employee(String name,String sur,int number,double salary)
	{
		setFirstName(name);
		setSurName(sur);
		setStaffNumber(number);
		setAnnualSalary(salary);
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getSurName() 
	{
		return surName;
	}

	public void setSurName(String surName)
	{
		this.surName = surName;
	}

	public int getStaffNumber()
	{
		return staffNumber;
	}

	public void setStaffNumber(int staffNumber)
	{
		this.staffNumber = staffNumber;
	}

	public double getAnnualSalary() 
	{
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) 
	{
		this.annualSalary = annualSalary;
	}
	
	public String toString()
	{
		return "This employee is called :"+firstName+"\n"
				+ "His surname "+surName+"\n"
						+ " his staff number is "+staffNumber+"\n"
								+ " his salary is "+annualSalary;
	}
	
	public double calculatePay()
	{
		return annualSalary / 12;
	}
	
}
