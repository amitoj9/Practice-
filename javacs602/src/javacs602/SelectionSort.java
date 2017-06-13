package javacs602;

public class SelectionSort {
	public static void main(String args[])
	{
		int arraySelectionSort[]={5,9,8,3,2,1,10,4,6,7};
		System.out.println(args[0]);
		selectionSort(arraySelectionSort);
		for(int i=0;i<arraySelectionSort.length;i++)
			System.out.println(arraySelectionSort[i]);
	}
	/**
	 * @param arraySelectionSort
	 * @return
	 */
	public static int selectionSort(int arraySelectionSort[])
	{
		for(int i=0;i<arraySelectionSort.length;i++)
		{
			int min=i;
			for(int j=i+1;j<arraySelectionSort.length;j++)
			{
				if(arraySelectionSort[min]>arraySelectionSort[j])
				{   min=j;
					int temp=arraySelectionSort[min];
					arraySelectionSort[min]=arraySelectionSort[i];
					arraySelectionSort[i]=temp;
				}
			}
		
		}
		return 0;
	}
	
}
/*
 * Selection Sort [Best/Worst: O(N^2)]
 * 
 * Scan all items and find the smallest. Swap it into position as the first
 * item. Repeat the selection sort on the remaining N-1 items.
 * I found this the most intuitive and easiest to implement — you always iterate
 * forward (i from 0 to N-1), and swap with the smallest element (always i).
 */