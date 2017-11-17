package datastructure.sortingalgos;

public class InsertionSort {

	public static void main(String argsp[])
	{
		int arr[]= {321,1,23,412};
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		insertionSort(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	public static void insertionSort( int [ ] num)
	{
	     int j;                     // the number of items sorted so far
	     int key;                // the item to be inserted
	     int i;  

	     for (j = 1; j < num.length; j++)    // Start with 1 (not 0)
	    {
	           key = num[ j ];
	           for(i = j - 1; (i >= 0) && (num[ i ] > key); i--)   // Smaller values are moving up
	          {
	                 num[ i+1 ] = num[ i ];
	          }
	         num[ i+1 ] = key;    // Put the key in its proper location
	     }
	}
}
