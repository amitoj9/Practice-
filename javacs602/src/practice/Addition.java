package practice;

import java.util.Scanner;

public class Addition {

	public  static void main(String string[])
	{
		Addition a= new Addition();
		a.add(123, 123);
		
		Scanner s= new Scanner(System.in);
		System.out.println("Enter your option");
		int af=s.nextInt();
		System.out.println(af);
	}
	/*public static int add(int a, int b)
	{
		return a+b;
	}*/
	public int add(int a, int b)
	{
		return a+b;
	}
}
