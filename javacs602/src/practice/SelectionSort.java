package practice;

public class SelectionSort {

	public static int selectionSort(int a[])
	{
		for(int i=0; i<a.length;i++)
		{
			int index=i;
			for(int j=i+1;j<a.length;j++)
			{
				if(a[j]<a[index])
				{
					index=j;
				}
			}
		}
		return 0;
	}
}
