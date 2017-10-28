package practice;

public class MyThread implements Runnable 
{
public void run()
{
	for(int i=1;i<=1000;i++)
	{
		System.out.println(i);
	}
}
public static void main(String[] args)
{
	MyThread obj=new MyThread();
	Thread t=new Thread(obj);
	t.run();
	t.start();
}
}
