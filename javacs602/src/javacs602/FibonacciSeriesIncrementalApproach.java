package javacs602;

public class FibonacciSeriesIncrementalApproach {
	public static void getFibonacciSeries(long n[])
	{
		n[0]=0;
		n[1]=1;
		for(int i=2;i<n.length;i++)
		{
			n[i]=n[i-1]+n[i-2];
		}
		for(int i=0;i<n.length;i++)
		System.out.println(n[i]+" "+ i);
	}
	public static void main(String args[])
	{
		getFibonacciSeries(new long[100000]);
	}

}
