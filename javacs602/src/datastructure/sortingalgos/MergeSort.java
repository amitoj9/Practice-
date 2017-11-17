package datastructure.sortingalgos;

public class MergeSort {

	public static void main(String args[])
	{
		 
	    	int af[]= {2,1,5,229,9};
			int bg[]= {0,1,2,3,4};
			printArray(af);
			mergeSort(af, 0, 4);
			printArray(af);
	}

	 static int[] mergeArrays(int[] a, int[] b) {
	        int m[]= new int[a.length+b.length];
        int k=0,i=0,j=0;
        
        while( i<a.length && j<b.length)
        {
           if(a[i]<b[j])
           {
               m[k]=a[i];
               i++;
               k++;
           }
            else
            {
                m[k]=b[j];
                j++;
                k++;
            }
        }
	        if(i<a.length)
           {
               for(int ss= i;ss<a.length;ss++,k++)
               {
                   m[k]=a[ss];
               }
           }
        if(j<b.length)
        {
            for(int ss=j;ss<b.length;ss++,k++)
                m[k]=b[ss];
        }
	        return m;
	    }

	 static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	public static void mergeSort(int arr[], int l, int r)
	{
		if(l<r)
		{
			int m=l+(r-l)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			
			merge(arr,l,m,r);
		}
		
	}
	
	public static void merge(int arr[], int l,int m, int r )
	{
		
		int n1=m-l+1;
		int n2=r-m;
		  /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
        
		 for (int i=0; i<n1; ++i)
	            L[i] = arr[l + i];
	     for (int j=0; j<n2; ++j)
	            R[j] = arr[m + 1+ j];
	     int i = 0, j = 0;
	     
	        // Initial index of merged subarry array
	        int k = l;
	        while (i < n1 && j < n2)
	        {
	            if (L[i] <= R[j])
	            {
	                arr[k] = L[i];
	                i++;
	            }
	            else
	            {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	        
	        while (i < n1)
	        {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        /* Copy remaining elements of R[] if any */
	        while (j < n2)
	        {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	}
}
