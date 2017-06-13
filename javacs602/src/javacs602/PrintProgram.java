package javacs602;

public class PrintProgram {

	public static void main(String args[])
	{
		for(int i=1;i<=100;i++)
		{
			if(i%15==0)
			{
				System.out.println("rightpoint");
			}
			else if(i%5==0)
				{
				System.out.println("point");
				}
			else if(i%3==0)
			{
				System.out.println("right");
			}
			else{
				System.out.println(i);
			}
		}
	}
}
