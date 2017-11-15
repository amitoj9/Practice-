package practice;

import java.util.Scanner;

public class OrderString {
	
	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner sc= new Scanner (System.in);
	        
	        int numberOfLines=sc.nextInt();
	        String ar[]=new String[numberOfLines+1];
	        for(int i=0;i<=numberOfLines;i++)
	            ar[i]=sc.nextLine();
	        
	        String lastLine=sc.nextLine();
	        String arr[]=lastLine.split(" ");
	        
	        int key=Integer.parseInt(arr[0]);
	        
	            String test[]=ar[1].split(" ");
	            int numbers[][]= new int[numberOfLines+1][test.length+1];
	             for(int i=1;i<=numberOfLines;i++)
	             { 
	                 String temp[]= ar[i].split(" "); 
	                 for(int mm=0;mm<temp.length;mm++)
	                     numbers[i][mm]=Integer.parseInt(temp[mm]);
	             }
	            
	              for(int i=0;i<numbers.length;i++)
	             { 
	                 for(int mm=0;mm<numbers[i].length-1;mm++)
	                       System.out.println(numbers[i][mm]);
	             }
	        
	        String reversed=arr[1];
	        
	        String comparisonType=arr[2];
	        if(comparisonType.equals("numeric"))
	        {
	            
	        }
	        else
	        {
	            
	        }
	        System.out.println(key);
	        System.out.println(reversed);
	        System.out.println(comparisonType);
	            
	    }

}
