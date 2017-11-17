package dynamicprogramming;

public class BinomialCoefficient {

	public static void main (String args[])
	{
	System.out.println(binaomialCoeffCal(5,2));	
	}
	
	public static int binaomialCoeffCal(int n, int k)
	{
		int c[][]=new int[n+1][k+1];
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=Math.min(i, k);j++)
			{
				if(j==0||j==i)
				{
					c[i][j]=1;
				}
				else
				{
					c[i][j]=c[i-1][j-1]+c[i-1][j];
				}
			}
			
		}
		for(int i=0;i<=n;i++)
			for(int j=0;j<=k;j++)
		System.out.println(c[i][j]);
		return c[n][k];
	}
}
