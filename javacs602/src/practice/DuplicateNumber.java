package practice;

public class DuplicateNumber {

	public static void main(String args[])
	{
		int a[]={123,123,1,1,1,13,2,3123,123,1,231,23,1,23,123,12,3,1,34,345,56,756,7};
		for(int i=0;i<100;i++)
		{
			int flag=binarySearch( a,i);
			if(flag!=-1)
			{
				System.out.println("Duplicate number found in "+i+" and value is "+a[i]);
				return;
			}
		}
	}
	
	public static int binarySearch(int[] inputArr, int key) {
		
        int start = 0;
        int end = inputArr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key == inputArr[mid]) {
                return mid;
            }
            if (key < inputArr[mid]) {
            	end = mid - 1;
            } else {
            	start = mid + 1;
            }
        }
        return -1;
    }
}
