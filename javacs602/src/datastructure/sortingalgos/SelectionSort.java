package datastructure.sortingalgos;

public class SelectionSort {
	public static void main(String args[])
	{
		int arr[] = {64,25,12,22,11};
        sort(arr);
        System.out.println("");
        printArray(arr);
        
	}
	 public  static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
	public static void sort(int arr[])
	{
		int min_index;
		
		for(int i=0;i<arr.length;i++)
		{
			min_index=i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[min_index]>arr[j])
				{
					min_index=j;
				}
			}
			int temp=arr[min_index];
			arr[min_index]=arr[i];
			arr[i]=temp;
		}
	}

}
