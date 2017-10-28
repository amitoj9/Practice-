package dynamicprogramming;

public class LongestCommonSubSequence {
 
  /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
  int lcs( char[] X, char[] Y, int m, int n )
  {
	  for(int i=0;i<m;i++)
	  System.out.print(X[i]);
	  System.out.print(" ");
	  for(int i=0;i<n;i++)
	  System.out.print(Y[i]);
	  
	  System.out.println();
    if (m == 0 || n == 0)
      return 0;
    if (X[m-1] == Y[n-1])
      return 1 + lcs(X, Y, m-1, n-1);
    else
      return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
  }
 
  /* Utility function to get max of 2 integers */
  int max(int a, int b)
  {
    return (a > b)? a : b;
  }
 
  public static void main(String[] args)
  {
	  LongestCommonSubSequence lcs = new LongestCommonSubSequence();
    String s1 = "ABCDGH";
    String s2 = "AEDFHR";
 
    char[] X=s1.toCharArray();
    char[] Y=s2.toCharArray();
    int m = X.length;
    int n = Y.length;
 
    System.out.println("Length of LCS is" + " " +
                                  lcs.lcs( X, Y, m, n ) );
  }
 
}