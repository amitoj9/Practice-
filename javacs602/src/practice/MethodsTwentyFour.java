package practice;

import java.util.Scanner;
public class MethodsTwentyFour 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int[] values=new int[10];
		System.out.println("Enter the values :");
		for(int j=0;j<10;j++)
		{
			values[j]=sc.nextInt();
		}
		int[] arr2={1,2,3,4,5};
		int result=biggestvtalue(arr2);
		System.out.println("Result"+result);
		biggestvtalue(arr2);
	}
	static int biggestvtalue(int...arr)
	{
		int max=arr[0];
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		return max;
		
	}
}