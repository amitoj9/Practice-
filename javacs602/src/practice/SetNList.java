package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class SetNList {

	public static void main(String args[])
	{
		TreeSet<Integer> testTree= new TreeSet<>();
		List<Integer> a= new ArrayList<>();
		List<Integer> b= new ArrayList<>();
		a.add(10);
		a.add(20);
		a.add(40);
		b.add(1);
		b.add(4);
		b.add(12);
		b.add(51);
		b.add(105);

		b.add(122);
		b.add(511);
		b.add(105);
		b.add(122);
		testTree.addAll(a);
		testTree.addAll(b);
		Iterator i=testTree.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		HashMap<Integer,Integer> test= new HashMap<>();
		i=testTree.iterator();
		while (i.hasNext())
		{
			if(test.containsKey(i.next()))
			test.put((Integer)i.next(), test.get(i.next())+1);
			else
			{
				test.put((Integer)i.next(),1);
			}
		}
		for(Map.Entry m: test.entrySet())
		{
			System.out.println(m.getKey()+"  "+m.getValue());
		}
	}
}
