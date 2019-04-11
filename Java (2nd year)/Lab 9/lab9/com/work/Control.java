package lab9.com.work;

public class Control {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		TestHashSet set = new TestHashSet();
		
		set.printSet();
		set.addEntry("vatican");
		System.out.println("");
		set.printSet();
		System.out.println(set.matchEntry("Russia"));
		System.out.println(set.matchEntry("Spain"));
		System.out.println("\n\n\n\n\n");
		set.sortSet();
		System.out.println("\n\n\n\n\n");
		set.reverseSet();
		System.out.println("\n\n\n\n\n");
		set.shuffleSet();
		
	}

}
