package dynamicprogramming;

public class MaximumContiguousSum {

	public static void main(String args[])
	{
		int a[]= {-2,-4,-5,-7};
		System.out.println(maxSubArraySum(a));
	}
	
	public static int maxSubArraySum(int arr[])
	{
		int maxSumSoFar=0;
		int maxEndingHere=0;
		int startIndex=0;
		int endIndex=0;
		int temp=0;
		for(int i=0;i<arr.length;i++)
		{
			maxEndingHere=maxEndingHere+arr[i];
			if(maxEndingHere<0)
			{
				maxEndingHere=0;
				
				temp=i+1;
			}
			else if(maxSumSoFar<maxEndingHere)
			{
				maxSumSoFar=maxEndingHere;
				startIndex=temp;
				endIndex=i;
			
			}
				
		}
		System.out.println("Maximim so far is "+maxSumSoFar+" array start index is "+startIndex+" Array End index is "+endIndex);
		return maxSumSoFar;
	}
}
