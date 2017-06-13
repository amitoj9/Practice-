package javacs602;

public class CatchException {

	public static void main(String...strings)
	{
		try
		{
			int a=10;
			int b=20;
			int c=30;
			
			/*if(a<b)
			{
				throw new ExceptionB("Exception occurred ");
			}*/
			if(c>b)
			{
				throw new ExceptionC("Exception occurred ");
			}
		}
		catch(ExceptionA exceptionA)
		{
			System.out.println("Exception captured by class ExceptionA with reference of"+exceptionA);
		}
	}
}
