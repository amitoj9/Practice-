package practice;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		boolean flag=false;
		for(int i=2;i<=Math.sqrt(a);i++)
		{
			if(a%i==0)
			{
				System.out.println("Number is not prime it is devisible by "+i);
				flag=true;
				return;
			}
		}
		if(!flag)
		System.out.println("Number is prime");
		
	}
}
