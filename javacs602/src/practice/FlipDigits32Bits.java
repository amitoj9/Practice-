package practice;

import java.util.Scanner;

public class FlipDigits32Bits {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int len=sc.nextInt();
	        System.out.println(len);
	        for(int i=0;i<len;i++)
	        {
	        	long variable=sc.nextLong();
	        	char aas[]=Long.toBinaryString(variable).toCharArray();
	        	for(int ii=0;ii<aas.length;ii++)
	        	{
	        		if(aas[ii]=='0')
	        		{
	        			aas[ii]='1';
	        		}
	        		else
	        		{
	        			aas[ii]='0';
	        		}
	        	}
	        	variable=Long.parseLong(String.valueOf(aas));
//	        	Long.parseLong(variable)
	        	
	        }
	        
	    }
}
