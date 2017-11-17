package crackingthecodinginterview.chapter1;

public class StringUnique {

	public static void main(String args[])
	{
		String s= new String("asdfghjkla");
		System.out.println(isUniqueChars(s));
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
	public static boolean isUniqueChars(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
		int val = str.charAt(i) - 'a';
		System.out.println( val);
		System.out.println(1 << val);
		if ((checker & (1 << val)) > 0) return false;
		System.out.println(checker );
		checker |= (1 << val);
		System.out.println(checker );
		}
		return true;
		}
}
