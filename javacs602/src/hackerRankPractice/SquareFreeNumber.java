package hackerRankPractice;

import java.util.Scanner;

public class SquareFreeNumber {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc =new Scanner(System.in);
        
        int n=sc.nextInt();
        int k=sc.nextInt();
        
        int count=0;
        /*for(int i=1;i<=n;i++)
        {
           double temp=Math.pow(i, k);
            if(temp==i)
            {
                count++;
            }
            else if(temp>n)
            {
                count++;
            }
        }
        
        */
        /*int temp=k;
        for(int i=2;i<=n;i++)
        {
        	if(Math.pow(i, temp)<=n)
        	{
        	while(Math.pow(i, temp)<=n)
        	{
        		if(Math.pow(i, temp)<n&&Math.pow(i, temp)!=i)
        		{
        		count++;
        		}
        		temp++;
        	}
        temp=k;
        	}
        	else
        		break;
        	
        	
        }
        System.out.println(n-count);*/
        
        
        int cnt = 0;
        
        // Loop for square free numbers
        for (int i=1;i<=n; i++)
        {
            boolean isSqFree = true;
            for (int j=2; j*j<=i; j++)
            {
                // Checking whether square of a number
                // is divisible by any number which is
                // a perfect square
                if (i % (j*j) == 0)
                {
                    isSqFree = false;
                    break;
                }
            }
     
            // If number is square free
            if (isSqFree == true)
            {
               cnt++;
     
               // If the cnt becomes n, return
               // the number
            }
           
        
        }
        
        System.out.println(cnt);
    }
    
    void SieveOfEratosthenes(long []a)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[]=new boolean[11000];
     
        for ( int p=2; p*p<=11000; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true)
            {
                // Update all multiples of p
                for (int i=p*2; i<=11000; i += p)
                    prime[i] = false;
            }
        }
     
        // Store all prime numbers in a[]
        for (int p=2; p<=11000; p++)
            if (prime[p])
                a[p]=p;
    }
     
}
