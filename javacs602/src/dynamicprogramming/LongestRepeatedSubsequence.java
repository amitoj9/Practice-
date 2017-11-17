package dynamicprogramming;

public class LongestRepeatedSubsequence {
	public static void main(String args[])
	{
		System.out.println(lrs("AABCD",5));
	}
	
	public static int lrs(String str, int m)
	{
		int dp[][]=new int[m+1][m+1];
		for(int i=0;i<=m;i++)
			for(int j=0;j<=m;j++)
				dp[i][j]=0;
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=m;j++)
			{
				
				if(str.charAt(i-1)==str.charAt(j-1) && i!=j)
				{
					dp[i][j]=1+ dp[i-1][j-1];
				}
				else
					dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
			}
		}
		return dp[m][m];
	}

}
/*
 * This Program is not working properly;
 */
