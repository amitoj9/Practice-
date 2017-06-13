package datastructure.searchingalgos;

public class BinarySearchOverInfiniteLengthArray {
	
	public static void main(String args[])
	{
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int ans = findLast(10,arr);

		if (ans == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at index " + ans);
		
	}
	
	public static int findLast(int num, int arr[])
	{
		int l=0;
		int r=1;
		int val=arr[0];
		while(val<num)
		{
			l=r;
			r=2*r;
			val=arr[r];
			
		}
		return BinarySearchIterative.binarySearch(arr, num, l, r);
	}
	

}
