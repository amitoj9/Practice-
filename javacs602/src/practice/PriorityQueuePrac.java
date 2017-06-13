package practice;

import java.util.PriorityQueue;

public class PriorityQueuePrac {

	public static void main(String args[])
	{
		PriorityQueue<String> ss= new PriorityQueue<String>();
		ss.add("amitoj");
		ss.add("amitoj2");
		ss.add("amitoj4");
		ss.add("amito1j4");ss.add("ami321toj");
		ss.add("amito2j1");ss.add("amito123j");
		ss.add("amito21j");
		ss.add("amito24j");
		ss.add("amitoj2");
		for(String s:ss)
		{
			System.out.println(s);
		}
		System.out.println(ss.poll());
		for(String s:ss)
		{
			System.out.println(s);
		}
	}
}
