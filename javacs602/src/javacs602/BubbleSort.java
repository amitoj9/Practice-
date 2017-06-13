package javacs602;

public class BubbleSort {
	public static void main(String argsp[])
	{
		int bubbleArray[]= {10,5,1,5,6,7,3,2,8};
		bubbleSort(bubbleArray);
		for(int i=0;i<bubbleArray.length;i++)
		System.out.println(bubbleArray[i]);
	}
	public static int bubbleSort(int bubbleArray[])
	{
		for(int i=bubbleArray.length-1;i>0;i--)
		{
			for(int j=1;j<=i;j++)
			{
				if(bubbleArray[j]<bubbleArray[j-1])
				{
					int temp=bubbleArray[j];
					bubbleArray[j]=bubbleArray[j-1];
					bubbleArray[j-1]=temp;
				}	
			}
		
		}
		return 0;
	}

}
/*
 * Starting on the left, compare adjacent items and keep “bubbling” the larger
 * one to the right (it’s in its final place). Bubble sort the remaining N -1
 * items.
 * 
 * Though “simple” I found bubble sort nontrivial. In general, sorts where you
 * iterate backwards (decreasing some index) were counter-intuitive for me. With
 * bubble-sort, either you bubble items “forward” (left-to-right) and move the
 * endpoint backwards (decreasing), or bubble items “backward” (right-to-left)
 * and increase the left endpoint. Either way, some index is decreasing. You
 * also need to keep track of the next-to-last endpoint, so you don’t swap with
 * a non-existent item.
 * Best: O(n), Worst:O(N^2)]
 */
