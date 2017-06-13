package datastructure;

public class BinarySearch {

	public static void main(String args[])
	{
		int a[]={1,4,7,12,15,16,20,25,28,30,35,38,40};
		System.out.println(binarySearch(a,3, 0, a.length));
		
	}
	public static int binarySearch(int a[],int k,int l,int r)
	{
		int m=l+(r-l)/2;
		if(l>r)
		{
			return -1;
		}
		else{
			int res=compare(k,a[m]);
			
			if(res==0)
			{
				return m;
			}
			else{
				if(res<0)
				{
					m=binarySearch(a, k, l, m-1);
				}
				else
				{
					m=binarySearch(a, k, m+1, r);
				}
			}
		}
		return m;
	}
	public static int compare(int k,int m)
	{
		if(k==m)
		{
			return 0;
		}
		else if(k>m){
		return 1;
		}
		else return -1;
	}
}
