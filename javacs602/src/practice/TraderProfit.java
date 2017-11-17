package practice;

import java.util.Scanner;

public class TraderProfit {

	  static int traderProfit(int k, int n, int[] A) {
		     
		    // Complete this function
		    int profit=0;
		    int buy=0,sell=0,max=0;
		    boolean bought=false;
		    boolean sold=false;
		    for(int i=0;i<A.length-1;i++)
		    {
		        if(k>0)
		        {
		            if(A[i]<A[i+1]&& bought==false)
		            {
		                buy=A[i];
		                bought=true;
		            }
		            if(A[i]>max  && bought==true)
		            {
		            	max=A[i];
		            	sell=max;
		            	sold=true;
		            }
		            if(A[i]<buy)
		            {
		            	sell=max;
		                sold=true;
		            }
		            if(i+1==A.length-1&& bought==true)
		            {
		            	sell=max;
		            	sold=true;
		            }
		            
		            if(bought&&sold)
		            {
		                profit=profit+sell-buy;
		                sell=0;
		                buy=0;
		                bought=false;
		                sold=false;
		                k--;
		            }
		            
		        }
		    }
		    return profit;

		    }
	  
	 public static int  maxProfit(int price[], int n, int k)
	  {
	      int profit[][]=new int[k+1][n+1];
	      
	      for (int i = 0; i <= k; i++)
	          profit[i][0] = 0;
	   
	      for (int j= 0; j <= n; j++)
	          profit[0][j] = 0;
	   
	      for (int i = 1; i <= k; i++)
	      {
	          for (int j = 1; j < n; j++)
	          {
	              int max_so_far =  0;
	   
	              for (int m = 0; m < j; m++)
	                  max_so_far = Math.max(max_so_far,
	                     price[j] - price[m] + profit[i-1][m]);
	   
	              profit[i][j] = Math.max(profit[i][j-1], max_so_far);
	          }
	      }
	   
	      return profit[k][n-1];
	  }
	  
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    for(int a0 = 0; a0 < q; a0++){
        int k = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        System.out.println(maxProfit(arr,n,k));
    }
    in.close();
}
}