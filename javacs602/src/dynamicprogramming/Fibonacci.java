package dynamicprogramming;

public class Fibonacci {

	public static void main(String args[])
	{
		System.out.println(fiboRec(9));
		System.out.println(fibDyn(9));
	}
	
	public static int fiboRec(int b)
	{
		if(b<=1)
			return b;
		
		return fiboRec(b-1)+fiboRec(b-2);
	}
	
	public static int fibDyn(int b)
	{
		int f[]= new int[b+1];
		int i;
		f[0]=0;
		f[1]=1;
		
		for(i=2;i<=b;i++)
		{
			f[i]=f[i-1]+f[i-2];
		}
		return f[b];
	}
}
