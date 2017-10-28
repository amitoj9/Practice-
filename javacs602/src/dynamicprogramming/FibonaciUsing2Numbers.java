package dynamicprogramming;

import java.util.Scanner;

public class FibonaciUsing2Numbers {
	
	public static void main(String args[])
	{
		int a=0;
		int b=1;
		int c=0;
		Scanner sc=new Scanner (System.in);
		int n=sc.nextInt();
		for(int i=2;i<=n;i++)
		{
			c=a+b;
			a=b;
			b=c;
		}
		System.out.println(b);
	}

}
