package datastructure.searchingalgos;

public class BinarySearchIterative {

	public static void main(String args[])
	{
		int a[]={1,2,4,5,6};
		System.out.println(a[binarySearch(a,12,0,4)]);
	}
	
	public static int binarySearch(int ap[],int num, int l, int r)
	{
		while(l<=r)
		{
			int mid=l+((r-l)/2);
			if (ap[mid]==num)
				return mid;
			if(ap[mid]>num)
				r=mid-1;
			if(ap[mid]<num)
				l=mid+1;
		}
		return -1;
	}
}
