package practice;

public class TestLongestSequence {

	public static void main(String args[])
	{
		int arr[]={ 1, 12, 7, 5, 23, 11, 52, 31, 61, 69, 70, 2 };
		int lst[]=new int[arr.length];
		int max=-1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
				{
					if(max==-1||max<lst[j]+1)
					{
						max=lst[j]+1;
					}
				}
			}
			if(max==-1)
			{
				max=1;
			}
			lst[i]=max;
		}
		int index=-1;
		int result=-1;
		for(int j=0;j<lst.length;j++)
		{
			if(lst[j]>result)
			{
				result=lst[j];
				index=j;
			}
		}
		String path=arr[index]+ " ";
		int res=result-1;
		for(int i=index-1;i>=0;i--)
		{
			if(lst[i]==res)
			{
				path=arr[i]+"   "+path;
				res--;
			}
		}
		System.out.println("Longest Increasing subsequence: " + result);
		System.out.println("Actual Elements: " + path);	
	}
}

