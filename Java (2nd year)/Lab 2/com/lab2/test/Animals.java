package com.lab2.test;

public class Animals {
	
	private String Name;
	private String Breed;
	private String Colour;
	private boolean Domestic;
	private int Age;
	
	Animals(String name)
	{
		this.setName(name);
	}
	Animals(String name,String breed,String colour,boolean domestic,int Age)
	{
		this.setName(name);
		this.setBreed(breed);
		this.setColour(colour);
		this.setDomestic(domestic);
		this.setAge(Age);
	}
	
	public String toString()
	{
		String domestic;
		if(this.Domestic == true)
		{
			domestic = "domestic";
		}
		else
		{
			domestic = "not domestic";
		}
		return "This is "+getName()+" it is a "+getBreed()+" it is "+getColour()+" colour,it is a "+domestic+" animal,it is "+getAge()+" Years old";
		
	}
	public String getName() 
	{
		return Name;
	}
	public void setName(String name)
	{
		Name = name;
	}
	public String getBreed() 
	{
		return Breed;
	}
	public void setBreed(String breed)
	{
		Breed = breed;
	}
	public String getColour() 
	{
		return Colour;
	}
	public void setColour(String colour) 
	{
		Colour = colour;
	}
	public boolean getDomestic()
	{
		return Domestic;
	}
	public void setDomestic(boolean domestic) 
	{
		Domestic = domestic;
	}
	public int getAge()
	{
		return Age;
	}
	public void setAge(int age) 
	{
		Age = age;
	}
	public String MakeNoise()
	{
		if(Breed.equals("Dog"))
		{
			return "WOOOF";
		}
		else if (Breed.equals("Cat"))
		{
			return "MEOOOW";
		}
		else
		{
			return "Other animal sound";
		}
		
	}
	
	public String MakeNoise(boolean old)
	{
		if(old)
		{
			return "Quite Animal";
		}
		else
		{
			return MakeNoise(); 
		}
	}

}
