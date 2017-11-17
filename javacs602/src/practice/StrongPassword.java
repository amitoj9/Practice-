package practice;

import java.util.Scanner;

public class StrongPassword {

	  static int minimumNumber(int n, String password) {
	        // Return the minimum number of characters to make the password strong
	        int length=0;
	      
	        int countOfUpper=0;
	        int countOfLower=0;
	        int countOfSpecial=0;
	        int countOfNumbers=0;
	        
	        for(int i=0;i<password.length();i++)
	        {
	            if(password.charAt(i)>=48 && password.charAt(i)<=57)
	            {
	                countOfNumbers++;
	            }
	            if(password.charAt(i)>=65 && password.charAt(i)<=90)
	            {
	                countOfUpper++;
	            }
	            if(password.charAt(i)>=97 && password.charAt(i)<=122)
	            {
	                countOfLower++;
	            }
	            if(password.charAt(i)>=35 && password.charAt(i)<=38)
	            {
	                countOfSpecial++;
	            }
	            if(password.charAt(i)>=40 && password.charAt(i)<=43)
	            {
	                countOfSpecial++;
	            }
	             if(password.charAt(i)==64 || password.charAt(i)==45|| password.charAt(i)==33|| password.charAt(i)==95)
	            {
	                countOfSpecial++;
	            }
	           
	        }
	     
	        
	        if(countOfNumbers==0)
	            length++;
	        
	        if(countOfUpper==0)
	            length++;
	        
	        if(countOfLower==0)
	            length++;
	        
	        if(countOfSpecial==0)
	            length++;
	        if(password.length()<6)
	        {
	            return Math.max(length,6-password.length());
	        }
	        if(countOfNumbers>0 &&countOfUpper>0 && countOfLower>0 && countOfSpecial>0)
		           return 0;
	        
	        return length;
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String password = in.next();
	        int answer = minimumNumber(n, password);
	        System.out.println(answer);
	        in.close();
	    }
}
