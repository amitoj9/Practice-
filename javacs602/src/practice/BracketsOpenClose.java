package practice;

import java.util.Scanner;
import java.util.Stack;

public class BracketsOpenClose {

    public static boolean isBalanced(String expression) {
        Stack<Character> ss=new Stack<Character>();
        
        for(int i=0;i<expression.length();i++)
        {
            if(expression.charAt(i)=='(')
            {
                ss.push(expression.charAt(i));
            }
            if(expression.charAt(i)=='{')
            {
                ss.push(expression.charAt(i));
            }
            if(expression.charAt(i)=='[')
            {
                ss.push(expression.charAt(i));
            }
            if(expression.charAt(i)==')')
            {
            	if(ss.peek()==null)
            	{
            		return false;
            	}
                if(ss.pop()!='(')
                {
                    return false;
                    
                }
            }
            if(expression.charAt(i)=='}')
            {
            	if(ss.peek()==null)
            	{
            		return false;
            	}
                if(ss.pop()!='{')
                {
                    return false;
                    
                }
            }
            if(expression.charAt(i)==']')
            {
            	if(ss.peek()==null)
            	{
            		return false;
            	}
                if(ss.pop()!='[')
                {
                    return false;
                    
                }
            }
            
            
        }
        return true;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
