package practice;

public class BubbleSort {

	public static void main(String... args)
	{
		int arr[]={3,12,5,45,123,1235};
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		bubbleSort(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	public static  int bubbleSort(int a[])
	{
		int temp=0;
		boolean flag=false;
		for(int i=0;i<a.length;i++)
		{
			for(int j=1;j<(a.length-i);j++)
			{
				if(a[j]<a[j-1])
				{
					temp=a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
					flag=true;
				}
			}
			if(!flag)
			break;
			else
				flag=false;
		}
		return 0;
	}
}
