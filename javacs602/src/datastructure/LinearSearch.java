package datastructure;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String args[])
	{
		int a[]={123,12,1,23,4,122,3,41,24,21,41};
		Scanner sc= new Scanner(System.in);
		int num=sc.nextInt();
		for(int i=0;i<a.length;i++)
		{
			if(num==a[i])
			{
				System.out.println("Number found at position "+(i+1));
				return;
			}
		}
		System.out.println("num not found");
	}
}
