package practice;

import java.util.concurrent.CopyOnWriteArrayList;

import javafx.util.Pair;

public class HeapSort {

	public static void main(String args[])
	{
		
	}
	public static void buildMaxHeap(CopyOnWriteArrayList<Integer> a)
	{
		
	}
	public static void heapSort(CopyOnWriteArrayList<Integer> a)
	{
		buildMaxHeap(a);
		for(int i=a.size()-1;i>=1;i--)
		{
			Pair<Integer,Integer> s=exchange(a.get(i), a.get(0));
			a.get(0);
			Integer.valueOf(s.getKey());
//			set(s.getValue());
		}
	}
	public static void MaxDownHeap(CopyOnWriteArrayList<Integer> a,int i)
	{
		
	}
	public static Pair<Integer,Integer> exchange(Integer a, Integer b)
	{
		return new Pair<>(b,a);
	}
	
}
