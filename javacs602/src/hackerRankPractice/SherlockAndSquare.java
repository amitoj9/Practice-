package hackerRankPractice;

import java.util.Scanner;

public class SherlockAndSquare {
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		int coun[]=new int[a];
		for(int i=0;i<a;i++)
		{
			int start=sc.nextInt();
			int end=sc.nextInt();
			if(start>end)
			{
				coun[i]=0;
				continue;
			}
			coun[i]=0;
			for(int m=start;m<=end;m++)
			{
				double dd=Math.sqrt(m);
				
				double dc=dd- Math.floor(dd);
				if(dc==0)
				{
					coun[i]++;
				}
			}
		}
		for(int i=0; i<coun.length;i++)
		{
			System.out.println(coun[i]);
		}
	}

}
