/*
 * Control : Lab 2 task
 * author : Maciej skrzypczynski
 * Date : 07/02/2019
 */
package com.lab2.test;

import java.util.Scanner;

public class Control 
{

	public static void main(String[] args) 
	{
		//Vehicle car1 = new Vehicle("bob");
		//Vehicle car2 = new Vehicle("Bob","123abc",65,"red","automatic",4 );
		Animals an1 = new Animals("Bob","Dog","black",true,10);
		//System.out.println(an1.Name);
		System.out.println(an1);
		System.out.println("The Animals is "+an1.getAge()+" years old");
		an1.setAge(22);
		System.out.println("The Animals is "+an1.getAge()+" years old");
		System.out.println(an1.MakeNoise());
		System.out.println(an1.MakeNoise(true));
		System.out.println(an1.MakeNoise(false));
		
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter animals breed > ");
		String inputString = input.nextLine();
		an1.setBreed(inputString);
		System.out.println("The Animals breed is "+ an1.getBreed());
	}

}
