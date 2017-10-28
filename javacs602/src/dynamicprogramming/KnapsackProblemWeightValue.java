package dynamicprogramming;

import java.util.Arrays;

public class KnapsackProblemWeightValue {
	

/*	static int max(int a, int b) { return (a > b)? a : b; }
    
    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
       // Base Case
   if (n == 0 || W == 0)
       return 0;
     
   // If weight of the nth item is more than Knapsack capacity W, then
   // this item cannot be included in the optimal solution
   if (wt[n-1] > W)
      return knapSack(W, wt, val, n-1);
     
   // Return the maximum of two cases: 
   // (1) nth item included 
   // (2) not included
   else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
                    knapSack(W, wt, val, n-1)
                     );
     }

  
  // Driver program to test above function
  public static void main(String args[])
  {
       int val[] = new int[]{0,20, 19};
       int wt[] = new int[]{0,24, 20};
   int  W = 70;
   int n = val.length;
   System.out.println(knapSack(W, wt, val, n));
//   solve(wt, val, W, n);
   int valBook[]=new int[] {24,20};
   int price[]=new int[] {20,19};
   System.out.println(knapSackDynamic(W, valBook, price, 2));
   }
  
  static int knapSackDynamic(int W, int wt[], int val[], int n)
  {
       int i, w;
   int K[][] = new int[n+1][W+1];
    
   // Build table K[][] in bottom up manner
   for (i = 0; i <= n; i++)
   {
       for (w = 0; w <= W; w++)
       {
           if (i==0 || w==0)
                K[i][w] = 0;
           else if (wt[i-1] <= w)
                 K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
           else
                 K[i][w] = i;
       }
    }
    
    return K[n][W];
  }
  public static void solve(int[] wt, int[] val, int W, int N)
  {
      int NEGATIVE_INFINITY = Integer.MIN_VALUE;
      int[][] m = new int[N + 1][W + 1];
      int[][] sol = new int[N + 1][W + 1];
      for (int i = 1; i <= N; i++)
      {
          for (int j = 0; j <= W; j++)
          {
              int m1 = m[i - 1][j];
              int m2 = NEGATIVE_INFINITY; 
              if (j >= wt[i])
                  m2 = m[i - 1][j - wt[i]] + val[i];
              m[i][j] = Math.max(m1, m2);
              sol[i][j] = m2 > m1 ? 1 : 0;
          }
      }        
      int[] selected = new int[N + 1];
      for (int n = N, w = W; n > 0; n--)
      {
          if (sol[n][w] != 0)
          {
              selected[n] = 1;
              w = w - wt[n];
          }
          else
              selected[n] = 0;
      }
      System.out.print("\nItems with weight ");
      for (int i = 1; i < N + 1; i++)
          if (selected[i] == 1)
              System.out.print(val[i] +" ");
      System.out.println("are selected by knapsack algorithm.");
  }*/
	
	public static void main(String args[]){
		int[] weights = {24,20}; 
		int[] price= {20,19};
		int sackCapacity=50;
		int nItems = price.length;
		  //dp[i][w] - the maximum value of sub problem with i items and with w sack capacity.
		  //no need to initialize with zeros as in java, the defalt values are 0 for int premitive type.
		  int[][] dpTable = new int[nItems + 1][sackCapacity + 1];
		  boolean[][] keep = new boolean[nItems][sackCapacity + 1];
		 
		  //iterate through all of the items
		  for (int i = 1; i <= nItems; i++) {
		    //calculate sub problem for all weights
		    for (int w = 1; w <= sackCapacity; w++) {
		      if (weights[i - 1] > w) {
		        // we cannt take this weight as it exceeds sub problem with weight w and i items
		        dpTable[i][w] = dpTable[i - 1][w];
		      } else {
		        //Price if we include item i
		        int pYes = price[i - 1] + dpTable[i - 1][w - weights[i - 1]];
		        //Price if we include item i
		        int pNo = dpTable[i - 1][w];
		        if (pYes > pNo) {
		          //this item MAY go into sack
		          keep[i - 1][w] = true;
		          dpTable[i][w] = pYes;
		        } else {
		          dpTable[i][w] = pNo;
		        }
		      }
		    }
		  }
		  //printing dpTable
		  System.out.println(Arrays.deepToString(dpTable));
		}
	
	
	
}
