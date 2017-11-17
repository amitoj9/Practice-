package practice;

import java.util.Scanner;

public class SemiPrimes {

	public static void main(String args[])
	{	
		Scanner sc= new Scanner(System.in);
        int numOfTestCases=sc.nextInt();
        while(numOfTestCases>0)
        {
            
            int number=sc.nextInt();
	    int i=0;
        for(int p = 2; p <=number/2; p++)
        {
           if(isPrime(p))
           {
//        	   prime[i]=p;
        	   i++;
           }
        }
        int prime[] = new int[i];
        i=0;
        for(int p = 2; p <=number/2; p++)
        {
           if(isPrime(p))
           {
        	   prime[i]=p;
        	   i++;
           }
        } 
        // Print all prime numbers
        for( i = 0; i < prime.length; i++)
        {
        	for(int j=i;j<prime.length;j++)
        	{
        		 
        		
        			 if(prime[i]*prime[j]<=number)
        			 {
        				 System.out.println(prime[i]*prime[j]);
        				 count++;
        			 }
        	}
        }
//        System.out.println(count);
  
            
            
            numOfTestCases--;
        }
		}
	
	public static boolean isPrime(int a)
	{
		for(int i=2;i<=Math.sqrt(a);i++)
		{
			if(a%i==0)
			{
				return false;
			}
			
		}
		return true;
	}
}
