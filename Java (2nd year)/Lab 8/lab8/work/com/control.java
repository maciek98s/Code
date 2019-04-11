/*
 * Author:Maciej Skrzypczynski
 * Date: 28/03/2019
 * Description: Control class for using arralist and using arraylist in a gui 
 */
package lab8.work.com;

import java.util.ArrayList;

public class control {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		GUI gi = new GUI("Lab 8 GUI");
		Person p1 = new Person("Bob","mcBOB","Barcelona");
		Person p2 = new Person("Mac","mcBOB","Dublin");
		Person p3 = new Person("Cormac","mcBOB","Moskow");
		
		ArrayList<Person> list = new ArrayList<Person>();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		System.out.println("length of the array list is "+list.size());
		for (Person i: list)
		{
			System.out.println(i);
		}
		
		ArrayList<Person> list2 = (ArrayList<Person>)list.clone();
		
		System.out.println("length of the array list is "+list.size());
		for (Person i: list2)
		{
			System.out.println(i);
		}
	}

}
