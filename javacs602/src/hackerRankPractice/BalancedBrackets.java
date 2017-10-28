package hackerRankPractice;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            String s = in.next();
	            String result = isBalanced(s);
	            System.out.println(result);
	        }
	        in.close();
	    }

	    static String isBalanced(String s) {
	        // Complete this function
	    	Stack<Character> ssa= new Stack<Character>();
	        for(int i=0;i<s.length();i++)
	        {
	        	switch(s.charAt(i))
	        	{
	        	case '{':
	        		ssa.push('{');
	        		break;
	        	case '}':
	        		ssa.contains('{');
	        		break;
	        	case '[':
	        		break;
	        	case ']':
	        		break;
	        	case '(':
	        		break;
	        	case ')':
	        		break;
	        		
	        		
	        	}
	        }
	    	
	        return s;
	    }
}
