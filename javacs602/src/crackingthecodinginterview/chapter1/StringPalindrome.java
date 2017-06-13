package crackingthecodinginterview.chapter1;

public class StringPalindrome {

	public static void main(String[] args) {
		isPermutationOfPalindrome("amitoj jotima");
	}
	public static boolean isPermutationOfPalindrome(String phrase)
	{	int table[];
		table=buildCharFrequecyTable(phrase);
		for(int i=0;i<table.length;i++)
		{
			System.out.println(table[i]);
		}
		return checkMaxOddCount(table);
	}
	public static boolean checkMaxOddCount(int[] table)
	{
		for(int i=0;i<table.length;i++)
		{
			if(table[i]%2!=0)
			{
				return false;
			}
		}
		return true;
	}
	public static int getCharNumber(char x)
	{
		int a=Character.getNumericValue('a');
		int z=Character.getNumericValue('z');
		if(a<=Character.getNumericValue(x)&&Character.getNumericValue(x)<=z)
		{
			return Character.getNumericValue(x)-a;
		}
		return -1;
	}
	public static int[] buildCharFrequecyTable(String phrase)
	{
		int table[]= new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		for(char c:phrase.toCharArray())
		{
			int x=getCharNumber(c);
			if(x!=-1)
			{
				table[x]++;
			}
		}
		return table;
	}
}
