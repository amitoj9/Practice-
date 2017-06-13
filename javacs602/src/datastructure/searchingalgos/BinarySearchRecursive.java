package datastructure.searchingalgos;

public class BinarySearchRecursive {

	public static void main(String args[])
	{
		int a[]={1,2,4,5};
		System.out.println(a[binarySearch(a,4,0,4)]);
	}
	
	public static int binarySearch(int ap[], int num,int l,int r)
	{
		if(r>=1)
		{
			int mid= l+   ((r-l)/(2)) ;

			if(ap[mid]==num)
			{
				return mid;
			}
			if(ap[mid]>num)
				return binarySearch(ap,num,l,mid-1);
			if(ap[mid]<num)
				return binarySearch(ap, num, mid+1, r);
				
		}
		
		return -1;
		
	}
}
