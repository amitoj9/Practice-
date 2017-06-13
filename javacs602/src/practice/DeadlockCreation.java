package practice;

public class DeadlockCreation {
private static Object ojb1=new Object();
private static Object ojb2=new Object();
	public static void main(String args[])
	{
		ThreadDemo1 demo1=new ThreadDemo1();
		demo1.start();
		ThreadDemo2 demo2=new ThreadDemo2();
		demo2.start();
	}
	public static class ThreadDemo1 extends Thread
	{
		public void run()
		{
			synchronized (ojb1) {
				System.out.println("Thread 1 locked obj1");
				try
				{
					sleep(10);
				}
				catch(InterruptedException exception)
				{
					
				}
				System.out.println("Waiting for obj2");
			synchronized (ojb2) {
			System.out.println("Thread 1 locked obj2");
			}
			}
		}
	}
	public static class ThreadDemo2 extends Thread
	{
		public void run()
		{
			synchronized (ojb1) {
				System.out.println("Thread 2 locked obj2");
				try
				{
					sleep(10);
				}
				catch(InterruptedException exception)
				{
					
				}
				System.out.println("Waiting for obj1");
			synchronized (ojb2) {
			System.out.println("Thread 2 locked obj1");
			}
			}
		}
	}
}
