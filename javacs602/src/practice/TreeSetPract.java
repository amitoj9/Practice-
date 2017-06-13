package practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetPract {

	public static void main(String args[])
	{
		TreeSet<String> test= new TreeSet<String>();
		test.add("amitoj");
		test.add("amitoj2");
		test.add("amitoj3");
		test.add("amitoj1");
		test.add("amitoj");
		Iterator<String> e=test.iterator();
		while(e.hasNext())
		{
			System.out.println(e.next());
		}
		ArrayList<String> pt= new ArrayList<>();
		pt.add("Singh1");
		pt.add("Singh2");
		pt.add("Singh3");
		pt.add("Singh4");
		System.out.println(pt);
		test.addAll(pt);
		System.out.println(test.descendingSet());
		System.out.println(test);
	}
}
/*
	TreeSet maintains ascending order contains unique values.
*/