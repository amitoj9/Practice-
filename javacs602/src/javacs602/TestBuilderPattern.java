package javacs602;

public class TestBuilderPattern {
	public static void main(String ...strings)
	{
		Computer computer=new Computer.ComputerBuilder("500", "4", true).build();
		System.out.println(computer);
		
	}

}
