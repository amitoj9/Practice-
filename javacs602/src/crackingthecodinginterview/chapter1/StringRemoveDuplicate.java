package crackingthecodinginterview.chapter1;

public class StringRemoveDuplicate {

	public static void removeDuplicate(char arg[])
	{
	 if(arg == null)
	 {
		 return;
	 }
	 int len=arg.length;
	 if(len<2)
	 {
		 return;
	 }
	 int tail=1;
	 for(int i=1;i<len;i++)
	 {
		 int j;
		 for(j=0;j<tail;j++)
		 {
			 if(arg[i]==arg[j])
			 {
				 break;
			 }
		 }
		 if(j==tail)
			 {
				 arg[tail]=arg[i];
				 tail++;
			 }
		 }
		 
	 
	 arg[tail]=0;
	 System.out.println(arg);
	}
	public static void main(String args[])
	{
		char []ar= new char[50];
		String string=new String("amitoj singh");
		ar=string.toCharArray();
		removeDuplicate(ar);
	}
}
