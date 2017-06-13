package practice;

import java.util.Scanner;

public class UpperLowerCase {
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		String a=s.nextLine();
		
		for(int i=0;i<a.length();i++)
		{
			if(Character.isLowerCase(a.charAt(i)))
				{
				System.out.print(Character.toUpperCase(a.charAt(i)));
				}
			else{
				System.out.print(Character.toLowerCase(a.charAt(i)));
			}
		}
		
	}
	

}
