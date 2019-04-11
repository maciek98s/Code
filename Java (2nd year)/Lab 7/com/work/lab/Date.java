package com.work.lab;

public class Date 
{
	private int day;
	private int month;
	private int year;
	
	public Date(int day,int month,int year)
	{
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	
	public String toString()
	{
		return +day+"/"+month+"/"+year+".";
	}

	
	
	//Getters and Setters
	int getDay() {
		return day;
	}

	void setDay(int day) 
	{
		if(day < 32 && day > 0 )
		{
			this.day = day;
		}
		else
		{
			System.out.println("Invalid Day Entered");
		}
	}

	int getMonth() 
	{
		return month;
	}

	void setMonth(int month) 
	{
		if(month < 13 && month > 0) 
		{
			this.month = month;
		}
		else
		{
			System.out.println("invalid month");
		}
	}

	int getYear() {
		return year;
	}

	void setYear(int year) {
		this.year = year;
	}

}
