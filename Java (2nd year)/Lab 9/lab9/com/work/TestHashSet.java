package lab9.com.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet 
{
	private HashSet<String> set;
	private ArrayList<String> list;
	private Iterator<String> it;
	private String[] countries = {"Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bosnia Herzegovina", "Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Estonia", "Hungary", "Iceland", "Ireland", "Italy", "Kosovo", "Latvia", "Liechtenstein",
			"Lithuania", "Luxemburg", "Macedonia", "Malta", "Moldova", "Monaco", "Montenegro", "Norway", "Poland",
			"Portugal", "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain",
			"Sweden", "Switzerland", "the Netherlands", "the United Kingdom", "Turkey", "Ukraine"};
	
	public TestHashSet()
	{
		set = new HashSet(Arrays.asList(countries));
		
	}
	
	void printSet()
	{
		it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
	void addEntry(String country)
	{
		set.add(country);
	}
	
	boolean matchEntry(String country)
	{
		if(set.contains(country))
		{
			return true;
		}
		return false;
	}
	
	void sortSet()
	{
		list = new ArrayList(set);
		Collections.sort(list);
		for(String x : list)
		{
			System.out.println(x);
		}

	}
	void reverseSet()
	{
		Collections.reverse(list);
		for(String x : list)
		{
			System.out.println(x);
		}

	}
	void shuffleSet()
	{
		list = new ArrayList(set);
		Collections.shuffle(list);
		for(String x : list)
		{
			System.out.println(x);
		}

	}

}
