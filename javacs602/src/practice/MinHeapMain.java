package practice;

import java.util.ArrayList;

public class MinHeapMain {

	public static void main(String args[])
	{
		ArrayList<Integer> a= new ArrayList<Integer>();
		a.add(1);
		a.add(1);
		a.add(0);
		a.add(7);
	/*	a.add(1241);
		a.add(441);
		a.add(411);*/
/*		MinHeap min= new MinHeap(a);
		System.out.println(min.extractMin());*/
		int af[]= {4,5};
		int bg[]= {3};
		
		buildHeap(mergeArrays(af, bg));
				
	}
	
	 static int[] mergeArrays(int[] a, int[] b) {
	        int m[]= new int[a.length+b.length];
	        for(int i=0;i<a.length;i++)
	        {
	        	m[i]=a[i];
	        }
	        for(int i=a.length,j=0;j<b.length;i++,j++)
	        {
	        	m[i]=b[j];
	        }
	        return m;
	    }
	 public static void buildHeap(int list[]) {

	        for (int i = list.length / 2; i >= 0; i--) {
	            minHeapify(i,list);
	        }
	        System.out.println(list[0]+" "+list[1]+""+list[2]);
	    }
	  static void minHeapify(int i, int list[]) {

	        int left = left(i);
	        int right = right(i);
	        int smallest = -1;

	        // find the smallest key between current node and its children.
	        if (left <= list.length - 1 && list[left] < list[i]) {
	            smallest = left;
	        } else {
	            smallest = i;
	        }

	        if (right <= list.length - 1 && list[right] < list[smallest]) {
	            smallest = right;
	        }

	        // if the smallest key is not the current key then bubble-down it.
	        if (smallest != i) {

	            swap(i, smallest,list);
	            minHeapify(smallest,list);
	        }
	    }
	  static int right(int i) {

	        return 2 * i + 2;
	    }

	    static int left(int i) {

	        return 2 * i + 1;
	    }

	    static int parent(int i) {

	        if (i % 2 == 1) {
	            return i / 2;
	        }

	        return (i - 1) / 2;
	    }
	    static void swap(int i, int parent,int list[]) {

	        int temp = list[parent];
	        list[parent]= list[i];
	        list[i]=temp;
	    }
}
