package practice;

import java.util.ArrayList;

public class ArraysFinal {
	
	public static void main(String arghs[])
	{
		final int[]  aa= {1,4,5,6,7,13};
		
		for(int i=0;i<aa.length;i++)
		{
			aa[i]=aa[i]+i+3;
		}
		
		for(int i=0;i<aa.length;i++)
		System.out.println(aa[i]);
	ArrayList<Integer> cc= new ArrayList<Integer>(10000);
	cc.add(2);
	cc.add(12);
	cc.add(21);
	cc.add(22);
	
	cc.forEach(System.out::println);
	}

}

/* This program is to check whether we can change the value of final array variable or not.
 * We can change the values of elements that are present in the array. 
 * But if we do something like this 	aa=new int[110];
 * This will not work.
 * 
 */
