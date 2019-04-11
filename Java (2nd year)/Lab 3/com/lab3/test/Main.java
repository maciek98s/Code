package com.lab3.test;

public class Main {

	public static void main(String[] args) 
	{
		Employee e1 = new Employee("bob","marley",123,12000);
		System.out.println(e1);
		System.out.println("his pay is equal to "+e1.calculatePay()+"\n");
		
		HourlyEmployee he1 = new HourlyEmployee("Bob","marley",1234,0,40,10);
		System.out.println(he1);
		System.out.println(" his pay is equal to "+he1.calculatePay()+"\n");
		
		ComissionEmployee com1 = new ComissionEmployee("Bob","marley",1234,0,100);
		System.out.println(com1);
		System.out.println(" his pay is equal to "+com1.calculatePay()+"\n");
		
		Employee[] myEmployee = new Employee[3];
		
		myEmployee[0] = new Employee("jack","wheelen",65234,50000);
		myEmployee[1] = new HourlyEmployee("jack","wheelen",65234,50000,50,12);
		myEmployee[2] = new ComissionEmployee("jack","wheelen",65234,50000,2000);
		
		
		for(int i = 0; i<myEmployee.length; i++)
		{
			System.out.println("Employee pay is equal to "+myEmployee[i].calculatePay());
		}
		
	}

}
