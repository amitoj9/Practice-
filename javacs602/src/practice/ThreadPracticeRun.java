package practice;

public class ThreadPracticeRun implements Runnable{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Waheguru"+i+Thread.currentThread().getName());		
		}
	
	}
	public static void main(String...strings )
	{
		ThreadPracticeRun practiceRun=new ThreadPracticeRun();
		
		Thread thread1=new Thread(practiceRun);
		Thread thread2=new Thread(practiceRun);
		thread1.setName("sdafas");
		thread1.start();
		try {
			thread1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start();
	}

}

/*
 * TIP1: It’s not guaranteed that thread mythread will start before thread
 * myrunnable it depends upon Thread scheduler.
 * 
 * TIP2: Thread will be said to go on dead state once execution of run() method
 * finished and you can not start that thread again.
 * 
 * 
 */
