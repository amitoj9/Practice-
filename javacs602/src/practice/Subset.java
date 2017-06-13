package practice;

import java.util.List;

public class Subset {
	public static void main(String args[])
	{
		int a[]={100,102,103,104,121,122,123,256};
		int b[]={1,4,16,25,121,256};
		int c[]=new int[13];
		int i=0,j=0,k=0;
		boolean flag=true;
		List<Integer>[] adj;
		
		
		while(i<a.length&&j<b.length)
		{
			if(a[i]==b[j])
			{
				c[k]=a[i];
				i++;
				j++;
				k++;
			}
			else if(a[i]<b[j])
				{
					c[k]=a[i];
					i++;
					k++;
				}
			else if(b[j]<a[i]){
					c[k]=b[j];
					k++;
					j++;
				}
			/*if(i>a.length-1||j>b.length-1)
			{
				break;
			}*/
				}
		/*while(i<a.length)
		{

			c[k]=a[i];
			i++;
			k++;
			
		}
		while(j<b.length)
			{
				c[k]=b[j];
				k++;
				j++;
			}*/
			
		for(int m=0;m<c.length;m++)
		System.out.println(c[m]);
	}
		
	
}
