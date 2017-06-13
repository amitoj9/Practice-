package practice;

public class Factorial {

	static int  factorial=1;
	public static void main(String...strings)
	{
		System.out.println(factorial(7));
	}
	public static int factorial(int number)
	{
		factorial=number*factorial;
		if(number>1)
		factorial(number-1);
		return factorial;
	}
}
