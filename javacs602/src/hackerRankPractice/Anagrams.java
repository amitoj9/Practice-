package hackerRankPractice;

import java.util.Scanner;

public class Anagrams {

	public static int numberNeeded(String first, String second) {
		int[] lettercounts = new int[26];
		for(char c : first.toCharArray()){
			lettercounts[c-'a']++;
		}
		for(char c : second.toCharArray()){
			lettercounts[c-'a']--;
		}
		int result = 0;
		for(int i : lettercounts){
			result += Math.abs(i);
		}
		return result;
	}

	  
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String a = in.next();
	        String b = in.next();
	        System.out.println(numberNeeded(a, b));
	    }
	    public int sortChar()
	    {
	    	return -1;
	    }
	    public static int binarySearch(int num, String second,int l, int r)
	    {
	    	while(l<=r)
	    	{
	    		int mid=l+((r-l)/2);
	    		if((int)second.charAt(mid)==num)
	    		{
	    			return mid;
	    		}
	    		if((int)second.charAt(mid)>num)
	    		{
	    			
	    		}
	    		if((int)second.charAt(mid)<num)
	    		{
	    			
	    		}
	    	}
	    	return -1;
	    }
}
