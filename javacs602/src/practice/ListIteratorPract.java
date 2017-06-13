package practice;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorPract {

	public static void main(String args[])
	{
		ArrayList<Integer> lsitAl=new ArrayList<Integer>();
		lsitAl.add(12);
		lsitAl.add(11);
		lsitAl.add(14);
		lsitAl.add(15);
		lsitAl.add(11);
		lsitAl.add(141);lsitAl.add(1123);
		lsitAl.add(111);
		ListIterator<Integer> iterator=lsitAl.listIterator();
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
