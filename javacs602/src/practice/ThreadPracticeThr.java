package practice;

public class ThreadPracticeThr extends Thread{

public void run()
{
	System.out.println("Hello "+Thread.currentThread().getName());
}
	public static void main(String... strings )
	{
		ThreadPracticeThr t= new ThreadPracticeThr();
		t.setName("Amitoj");
		
		t.start();
	}
	
}
