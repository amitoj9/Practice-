package javacs602;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BubbleSort {
	public static void main(String argsp[])
	{
		/*int bubbleArray[]= {10,5,1,5,6,7,3,2,8};
		bubbleSort(bubbleArray);
		for(int i=0;i<bubbleArray.length;i++)
		System.out.println(bubbleArray[i]);*/
	/*	int a=1;
		System.out.println(1<<2);
		System.out.println(max(10,4));
		int b=a++;
		int c=++b;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		try {
			
			Field f=BubbleSort.class.getDeclaredField("m_value");
			f.setAccessible(true);
			BubbleSort aa= new BubbleSort();
			f.set(aa, (char)'b');
			System.out.println(aa);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println(Byte.MAX_VALUE);
		for( byte bbb=Byte.MIN_VALUE;bbb<Byte.MAX_VALUE;bbb++)
		{
			if(bbb==0x90)
			{
				System.out.println("We fount");
			}
		}*/
	/*	Map<Integer,String > has= new HashMap<Integer,String>(1);
		has.put(1, "apple");
		
		for(String v:has.values())
		{
			if("apple".equals(v))
			{
				has.put(1, "aaa");
			}
		}
		System.out.println(has.get(1));*/
		final List<Integer> list= new ArrayList<Integer>();
		Collections.addAll(list, 1,2,4,5,76);
		Iterator i= list.iterator();
		while(i.hasNext())
		{
			
			System.out.println(i.next());
		}
		/*
		final Integer ps=Integer.valueOf(4);
		list.remove(ps);
		System.out.println(list);
		System.out.println((4>5)?"amitoj":"singh");*/
		
	}
	private final Character m_value='a';
	public String toString()
	{
		return ""+m_value;
	}
	public static void bubbleSort(int bubbleArray[])
	{
		for(int i=bubbleArray.length-1;i>0;i--)
		{
			for(int j=1;j<=i;j++)
			{
				if(bubbleArray[j]<bubbleArray[j-1])
				{
					int temp=bubbleArray[j];
					bubbleArray[j]=bubbleArray[j-1];
					bubbleArray[j-1]=temp;
				}	
			}
		
		}
		
	}
	static int max(int a,int b)
	{
		return (a>b)?a:b;
	}
	public static void filter(List<String> ll) throws Exception
	{
		
	
	}

}
/*
 * Starting on the left, compare adjacent items and keep “bubbling” the larger
 * one to the right (it’s in its final place). Bubble sort the remaining N -1
 * items.
 * 
 * Though “simple” I found bubble sort nontrivial. In general, sorts where you
 * iterate backwards (decreasing some index) were counter-intuitive for me. With
 * bubble-sort, either you bubble items “forward” (left-to-right) and move the
 * endpoint backwards (decreasing), or bubble items “backward” (right-to-left)
 * and increase the left endpoint. Either way, some index is decreasing. You
 * also need to keep track of the next-to-last endpoint, so you don’t swap with
 * a non-existent item.
 * Best: O(n), Worst:O(N^2)]
 */
