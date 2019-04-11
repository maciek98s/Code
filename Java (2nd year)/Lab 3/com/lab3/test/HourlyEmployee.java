package com.lab3.test;

public class HourlyEmployee extends Employee
{

	double hoursWorked;
	double hourlyRate;
	

	public HourlyEmployee(String Name,String sur,int Number,double Salary,double hoursWorked, double hourlyRate)
	{
		super(Name,sur,Number,Salary);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}
	

	public double calculatePay()
	{
		return (hoursWorked * hourlyRate);
	}
	

	public String toString()
	{
		return super.toString()+"\n They worked: "+hoursWorked+"hrs.\n"+ "The Hourly Rate is: €"+hourlyRate+".";
	}
}

