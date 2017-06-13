package practice;

import java.util.PriorityQueue;

public class BasicPriorityQueue {

	public static void main(String args[])
	{
		PriorityQueue<Integer> as=new PriorityQueue<Integer>();
		as.add(411);
		as.add(24);
		as.add(44);
		as.add(4);
		as.add(46);
		System.out.println(as.peek());
		System.out.println(as.peek());
		as.remove();
		System.out.println(as.peek());
		as.remove();
		System.out.println(as.peek());
		as.remove();
		System.out.println(as.peek());
	}
}
