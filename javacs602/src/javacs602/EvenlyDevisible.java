package javacs602;

import java.util.Scanner;

public class EvenlyDevisible {

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int count[]=new int[t];
        for(int a0 = 0; a0 < t; a0++){
            int a = in.nextInt();
            int b=a;
		count[a0]=0;
		
		while(a>0)
		{
			int temp=a%10;
			if(temp>0)
			if(b%temp==0)
			{
				count[a0]++;
			}
			a=a/10;
		}
        }
        for(int i=0;i<count.length;i++)
        {
        	System.out.println(count[i]);
        }

	}
}
