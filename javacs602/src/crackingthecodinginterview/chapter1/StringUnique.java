package crackingthecodinginterview.chapter1;

public class StringUnique {

	public static void main(String args[])
	{
		String s= new String("amitojsinghisaJavaDeveloperisdoingtestingforajavaapplicationwhichIdontknowhowitisworking");
		System.out.println(checkString(s));
	}
	public static boolean checkString(String str)
	{
		boolean checkNumber[]= new boolean[128];
		if(str.length()>128)
		{
		 return false;
		}
		int val=0;
		System.out.println(str.length());
		for(int i=0; i<str.length();i++)
		{
			val=str.charAt(i);
			System.out.println(val);
			if(checkNumber[val])
			{
				System.out.println(str.charAt(i));
				return false;
			}
			checkNumber[val]=true;
		}
		return false;
		
	}
}
