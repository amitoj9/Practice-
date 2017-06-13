package practice;

import java.util.Random;

public class MyQuickSort {
	
	public static void gt_qs(int a[],int n)
	{
		int b[]=gtqs(a,0,n-1);
		for(int i=0;i<b.length;i++)
		{
			System.out.println(b[i]);
		}
	}
	public static int[] gtqs(int a[],int l,int r)
	{
		if(l<r)
		{
			int m=gtPartition(a,l,r);
			gtqs(a,l,m-1);
			gtqs(a,m+1,r);
		}
		return a;
	}
	public static int gtPartition(int a[],int l,int r)
	{
		int piviot=r;
		int i=l;
		int j=r-1;
		while(i<=j)
		{
			while(i<=j&& a[i]<=a[piviot])
			i++;
			while(i<=j&& a[j]>=a[piviot])
			j--;
			if(i<j)
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}

		int temp=a[i];
		a[i]=a[r];
		a[r]=temp;
		return i;
	}
	public static int rgtPartition(int a[],int l, int r)
	{
		Random random=new Random();
		int ran=random.nextInt(l+1);
		int diff=(r-l);
		ran=ran+diff;

		int temp=a[r];
		a[r]=a[ran];
		a[ran]=temp;
		return gtPartition(a, l, r);
	}
	public static void main(String args[])
	{
		int a[]={5,20,15,31,20,30,20,17,20};
		gt_qs(a,a.length);
	}
	
}
