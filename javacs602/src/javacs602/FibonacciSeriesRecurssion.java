package javacs602;

public class FibonacciSeriesRecurssion {
	public static long getFibonacciSeries(int n)
	{	 if (n <= 1) return n;
	        else return getFibonacciSeries(n-1) + getFibonacciSeries(n-2);
	}

	    public static void main(String[] args) {
	        int n = 10000;
	        for (int i = 1; i <= n; i++)
	            System.out.println(i + ": " + getFibonacciSeries(i));
	    }

	}
	