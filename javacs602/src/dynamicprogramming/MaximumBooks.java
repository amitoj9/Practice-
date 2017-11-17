package dynamicprogramming;

public class MaximumBooks {

	public static void main(String args[])
	{
		int []bundleQuantities= {20,19};
		int []bundleCosts= {24,20};
		maximumBooks(50,2,bundleQuantities,2,bundleCosts);
	
	}
	
	
	public static long maximumBooks(int n,int bundleQuantities_size, int bundleQuantities[],int bundleCost_size, int bundleCosts[])
	{
		
		int table[][]=new int[bundleCost_size+1][n+1];
		
		for(int i=0;i<bundleQuantities_size+1;i++)
			for(int j=0;j<n+1;j++)
				table[i][j]=0;
		
//			for(int j=0;j<bundleQuantities_size;j++)
		int j=0;
				while(n>0)
				{
					table[j][bundleCosts[j]]+=1;
				}
			for(int i=0;i<bundleQuantities_size+1;i++)
				{
				for(int j=0;j<n+1;j++)
				{
					System.out.print(table[i][j]+"  ");	
				}
				System.out.println();
				}
			
		
		
		return 0;
	}
}
