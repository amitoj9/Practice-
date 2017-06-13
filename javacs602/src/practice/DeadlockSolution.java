package practice;

public class DeadlockSolution {
private static Object obj1=new Object();
private static Object obj2=new Object();
public static void main(String args[])
{
	ThreadDemo1 demo1=new ThreadDemo1();
	ThreadDemo2 demo2=new ThreadDemo2();
	demo1.start();
	demo2.start();
}
private static class ThreadDemo1 extends Thread
{
	public void run()
	{
		synchronized(obj1)
		{
			System.out.println("Thread 1 blocked obj1");
			try
			{sleep(100);
			}
			catch(InterruptedException exception)
			{
				
			}
			System.out.println("Thred1 waiting for obj2");
		}
		synchronized (obj2) {
			System.out.println("Thread1 locked obj2");
		}
	}
}
private static class ThreadDemo2 extends Thread
{
	public void run()
	{
		synchronized(obj1)
		{
			System.out.println("Thread 1 blocked obj1");
			try
			{sleep(100);
			}
			catch(InterruptedException exception)
			{
				
			}
			System.out.println("Thred1 waiting for obj2");
		}
		synchronized (obj2) {
			System.out.println("Thread1 locked obj2");
		}
	}
}
}
