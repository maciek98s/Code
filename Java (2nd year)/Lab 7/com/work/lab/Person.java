package com.work.lab;

public class Person 
{
	private String firstName;
	private String surname;
	private Date dateOfBirth;
	private String gender;
	
	public Person(String firstName,String surname,int day, int month,int year,String gender)
	{
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setGender(gender);
		this.dateOfBirth = new Date(day, month, year);
	}
	
	public String toString()
	{
		return("First Name: "+getFirstName()+"."
				+ "\nSurname: "+getSurname()+"."
						+ "\nDate of Birth: "+dateOfBirth
								+ "\nGender: "+getGender()+".\n");
	}
	
	
	
	
	

	String getFirstName() {
		return firstName;
	}

	void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	String getSurname() {
		return surname;
	}

	void setSurname(String surname) {
		this.surname = surname;
	}

	String getGender() {
		return gender;
	}

	void setGender(String gender) {
		this.gender = gender;
	}
	

}
