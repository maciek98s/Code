/*
 * Purpose : Class storing information about vehicles 
 * Author : Maciej Skrzypczynski
 * Date: 31/01/2019
 */

package com.lab1.test;

public class Vehicle 
{
	private String ownerName;
	private String registrationNum;
	private int maxSpeed;
	private String colour;
	private String Geartype;
	private int numofWheels;
	
	Vehicle(String name)
	{
		this.ownerName = name;
	}
	Vehicle(String name,String regisration,int speed,String colour,String Geartype,int wheels)
	{
		this.ownerName = name;
		this.registrationNum = regisration;
		this.maxSpeed = speed;
		this.colour = colour;
		this.Geartype = Geartype;
		this.numofWheels = wheels;
		System.out.println(name);
		System.out.println(regisration);
		System.out.println(speed);
		System.out.println(colour);
		System.out.println(Geartype);
		System.out.println(wheels);
	}
	public String toString()
	{
		return "The Owner is  "+ownerName+". The Vehicle registration is"+registrationNum+". The Speed limit is "+maxSpeed+"\n"
				+ " The car colour is "+colour+" The car is "+Geartype+" The car has"+numofWheels+" wheels";		
		
	}
}
