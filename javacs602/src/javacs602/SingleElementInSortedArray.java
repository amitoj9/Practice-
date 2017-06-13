package javacs602;

public class SingleElementInSortedArray {

	public static int singleNonDuplicate(int[] nums) {

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i - 1] != nums[i] || nums[i]!=nums[i+1]) {
				return (nums[i-1]);
			}

		}
		return 0;
	}
	public static void main(String args[])
	{
		int []ar= {1,1,2,2,3};
		System.out.println(singleNonDuplicate(ar));
		
	}
}
