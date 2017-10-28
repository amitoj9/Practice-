package practice;

public class Testingg {

	public static void main(String args[])
	{
		Testingg testingg=new Testingg();
		Testingg testingg3=new Testingg();
		Testingg testingg4=testingg.go(testingg3);
		testingg=null;
		
	}
	
	public Testingg go(Testingg gg)
	{
		gg=null;
		return gg;
	}
	
}
