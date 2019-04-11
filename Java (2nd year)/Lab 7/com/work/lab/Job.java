package com.work.lab;

public class Job 
{
	private double salary;
	private String role;
	private int jobID;
	
	public Job(double salary,String role,int jobID)
	{
		this.setSalary(salary);
		this.setRole(role);
		this.setJobID(jobID);
		
	}
	
	public String toString()
	{
		return "Job is: "+getRole()+". Salary is "+getSalary()+". Job ID is "+getJobID();
	}

	double getSalary() {
		return salary;
	}

	void setSalary(double salary) {
		this.salary = salary;
	}

	String getRole() {
		return role;
	}

	void setRole(String role) 
	{
		boolean Valid;
		FileProcessing f1 = new FileProcessing("roles.txt");
		f1.openFile();
		Valid = f1.ValidateString(role);
		if(Valid == true)
		{
			this.role = role;
		}
		f1.closeFile();
	}

	int getJobID() {
		return jobID;
	}

	void setJobID(int jobID) {
		this.jobID = jobID;
	}
}
