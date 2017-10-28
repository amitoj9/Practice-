package practice;

import java.util.ArrayList;

public class MaxHeapMain {


public static void main(String args[])
{
	ArrayList<Integer> a= new ArrayList<Integer>();
	a.add(1);
	a.add(21);
	a.add(220);
	a.add(7);
	a.add(1241);
	a.add(441);
	a.add(411);
	MinHeap min= new MinHeap(a);
	System.out.println(min.extractMin());
	
	MaxHeap max= new MaxHeap(a);
	System.out.println(max.extractMax());
	max.insert(22332);
	System.out.println(max.extractMax());
	System.out.println(max.extractMax());
	System.out.println(max.extractMax());
}
}