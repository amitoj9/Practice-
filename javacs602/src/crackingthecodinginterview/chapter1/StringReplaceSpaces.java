package crackingthecodinginterview.chapter1;

public class StringReplaceSpaces {

	public static void main(String args[])
	{
		
		String ar=new String("Amitoj Singh is a Java Developer");
		replaceSpaces(ar);
	}
	
	public static void replaceSpaces(String ar)
	{
		int spaceCount=0;
		
		for(int i=0;i<ar.length();i++)
		{
			if(ar.charAt(i)==' ')
			{
				spaceCount++;
			}
		}
		System.out.println(spaceCount);
		int index=ar.length()+2*spaceCount;
		char testing[]=new char[index];
		
		for(int i=ar.length()-1;i>=0;i--)
		{
			if(ar.charAt(i)==' ')
			{
				testing[index-1]='0';
				testing[index-2]='2';
				testing[index-3]='%';
				index=index-3;
			}
			else
			{
				testing[index-1]=ar.charAt(i);
				index--;
			}
			
		}
		System.out.println(testing);
	}
}
