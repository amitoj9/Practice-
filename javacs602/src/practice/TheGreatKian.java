package practice;

import java.util.Scanner;

public class TheGreatKian {

	public static void main(String args[])
	{
	
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the length of integer");
		int a=s.nextInt();
		int ar[]=new int[a];
		for(int i=0;i<a;i++){
		System.out.println("Enter the integers");
		ar[i]=s.nextInt();
		}
		int output[]=new int[3]; 
		Integer qwea= new Integer(0);
		for( int i=0;i<3;i++)
		{
			int count=i;
			while(count<a)
			if(a>i)
			{
				int temp=output[i];
				output[i]=ar[count]+temp;
				count=count+3;
				
			}	
		}
		for(int i=0;i<output.length;i++)
		{
			System.out.print(output[i]+" ");
		}
		
		
	}
	
}
/*
 * The great Kian is looking for a smart prime minister. He's looking for a guy
 * who can solve the OLP (Old Legendary Problem). OLP is an old problem
 * (obviously) that no one was able to solve it yet (like P=NP).
 * 
 * But still, you want to be the prime minister really bad. So here's the
 * problem:
 * 
 * Given the sequence a1, a2, ..., an find the three values a1 + a4 + a7 + ...,
 * a2 + a5 + a8 + ... and a3 + a6 + a9 + ... (these summations go on while the
 * indexes are valid).
 * 
 * Input
 * 
 * The first line of input contains a single integer n (1 ≤ n ≤ 105).
 * 
 * The second line contains n integers a1, a2, ..., an separated by space (1 ≤
 * ai ≤ 109).
 * 
 * Output
 * 
 * Print three values in one line (the answers).
 * 
 * 
 */