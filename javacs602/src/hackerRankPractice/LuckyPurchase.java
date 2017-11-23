package hackerRankPractice;

import java.util.Scanner;

public class LuckyPurchase {
	  public static void main(String[] args) {
	        int countOfFour=0;
	        int countOfSeven=0;
	        int val=0;
	        String lastName="";
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        for(int a0 = 0; a0 < n; a0++){
	            String name = in.next();
	            int value = in.nextInt();
	            int temp=value;
	            int currentCountOfSeven=0;
	            int currentCountOfFour=0;
	            while(temp>0)
	            {
	            	int t=temp%10;
	            	if(t!=7&&t!=4 )
	            	{
	            		currentCountOfFour=-1;
	            		break;
	            	}
	            	else if(t==4)
	            	{
	            		currentCountOfFour++;
	            	}
	            	else 
	            	{
	            		currentCountOfSeven++;
	            	}
	            	temp=temp/10;
	            }
	          
	            if(currentCountOfFour!=-1 && currentCountOfFour==currentCountOfSeven )
	            {
	            
	            	if(a0==0)
	            	{
	            		lastName=name;
	            		val=value;
	            		countOfFour=currentCountOfFour;
	            		countOfSeven=currentCountOfSeven;
	            	}else if(countOfFour>currentCountOfFour)
	            	{
	            		lastName=name;
	            		val=value;
	            		countOfFour=currentCountOfFour;
	            		countOfSeven=currentCountOfSeven;
	            	}
	            
	            }
	            else
	            {
	            	if(a0==0)
	            	{
	            	lastName="";
	            	val=-1;
	            }
	            }
	            
	        }
	        if(val==-1)
	            System.out.println(val);
	        else
		        System.out.println(lastName);
		        
	        in.close();
	    }
	}