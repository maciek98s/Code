package com.work.lab;

public class Employee extends Person
{

	Job job;
	int personnelNumber;
	Date startDate;
	static int nextNum = 0;
	
	public Employee(String firstName, String surname, int day, int month, int year, String gender,double salary, String role,int jobID,int personnelNumber,int sday, int smonth,int syear)
	{
		super(firstName, surname, day, month, year, gender);
		// TODO Auto-generated constructor stub
		
		this.job = new Job(salary,role,jobID);
		this.personnelNumber = personnelNumber;
		this.startDate = new Date(sday,smonth,syear);
		nextNum += 1;
	}
	
	
	public String toString()
	{
		FileProcessing writefile = new FileProcessing("names.txt");
		writefile.writeTofile(getFirstName()+" "+getSurname());
		return super.toString()+job+". Personnel Number of "+personnelNumber+". Start Date:"+startDate;
		
	}
}
