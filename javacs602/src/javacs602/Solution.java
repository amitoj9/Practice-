package javacs602;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	String a;
    	boolean ar[]=new boolean[26];
    	Scanner sc=new Scanner(System.in);
    	a=sc.nextLine();
    	a=a.toLowerCase();
    	for(int i=0;i<a.length();i++)
    	{
    		if((int)a.charAt(i)>96)
    		{	
    		ar[a.charAt(i)-97]=true;
    		}
    	}
    	boolean flag=false;
    	for(int i=0;i<26;i++)
    		{
    		if(!ar[i])
    		{
    			flag=true;
    		}
    		}
    	if(flag)
    	System.out.println("not ");
    	
    	int a2[]={-1,-2,-3,-4,-5};
    	
    			
		System.out.println(twoSum(a2,-3));
    }
    public static int[] twoSum(int [] nums, int target)
    {
    	int aa[]= new int[2];
    	for( int i=0; i<nums.length;i++)
    	{
    		int temp=target-nums[i];
    		int result=binarySearch(nums,temp,0,nums.length);
    		if(result!=-1)
    		{
    			aa[0]=i;
    			aa[1]=result;
    			return aa;
    		}
    	}
    	
    	
    	return null;
    }
    
   public static int  binarySearch(int arr[], int x, int l, int r)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the middle itself
            if (arr[mid] == x)
               return mid;
 
            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid+1, r, x);
        }
 
        // We reach here when element is not present in array
        return -1;
    }
	
   
}