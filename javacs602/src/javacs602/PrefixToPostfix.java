package javacs602;

public class PrefixToPostfix {

	public static void main(String args[])
	{
		prefixToPostfix("abd[]");
	}
	
	public static void prefixToPostfix(String expression)
	{
		java.util.Stack<Character> ss=new java.util.Stack<Character>();
		
		for(int i=0;i<expression.length();i++)
		{
			ss.push(expression.charAt(i));
		}
		
		while(ss.peek()!=null)
		{
			System.out.print(ss.pop());
		}
	}
}
