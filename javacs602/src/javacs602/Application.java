package javacs602;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Application {
	
	private static Integer txtFirstClassArrival;
	private static Integer txtCoachArrival;
	private static Integer txtFirstClassService;
	private static Integer txtCoachService;
	private static Integer txtDuration;
	private List<Station> stations;
	private boolean flag = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		/*Application application = new Application();
		Scanner sc = new Scanner(System.in);
//		Idhar likhna sysout;
		txtFirstClassArrival = sc.nextInt();
		txtCoachArrival = sc.nextInt();
		txtFirstClassService = sc.nextInt();
		txtCoachService = sc.nextInt();
		txtDuration = sc.nextInt();
		application.testSimulation();
		*/
	         solve();
	       
	}
	static void solve() {
        // Complete this function
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		arr[i][j]=0;
        	}
        }
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		 System.out.print(arr[i][j]);
        	       
        	}
        	System.out.println();
        }
        int m = in.nextInt();
        boolean flag=true;
        for(int a0 = 0; a0 < m; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int w = in.nextInt();
            // Write Your Code Here
            
            
            int ww=w;
            int minX=0,minY=0,maxX=0,maxY=0;
            int tt=1;
            arr[x][y]=w;
            w-=1;
            while(w>0)
            {
            minX=x-tt;
            minY=y-tt;
            if(minX<0)
            {
            	minX=0;
            	
            }
            if(minY<0)
            {
            	minY=0;
            	
            }
            
            
            maxX=x+tt;
            maxY=y+tt;
            if(maxX>=n)
            {
            	maxX=n-1;
            	
            }
            if(maxY>=n)
            {
            	maxY=n-1;
            	
            }
            tt++;
            for(int i=minX;i<=maxX;i++)
            {
            	
            	if(arr[i][minY]==0 &&flag)
            		arr[i][minY]=w;
            	
            }
            for(int i=minX;i<=maxX;i++)
            {
            	
            		arr[i][maxY]=w;
            	
            }
            for(int i=minY;i<=maxY;i++)
            {
            	
            		arr[minX][i]=w;
            	
            }
            for(int i=minY;i<=maxY;i++)
            {
            	
            		arr[maxX][i]=w;
            	
            }
            w--;
            }
           
        }
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		 System.out.print(arr[i][j]);
        	       
        	}
        	System.out.println();
        }
        
    }


	private void testSimulation() {
		// Initialize parameters.
		IQueue first = new Queue();
		IQueue coach = new Queue();
		List<Passenger> allPassengers = new ArrayList<Passenger>();
		stations = new ArrayList<Station>();
		Passenger.count = 1;
		stations.add(new FirstClassStation(1));
		stations.add(new FirstClassStation(2));
		stations.add(new Station(1));
		stations.add(new Station(2));
		stations.add(new Station(3));
		final int A1, A2, B1, B2, DUR;
		try {
			A1 = txtFirstClassArrival;
			A2 = txtCoachArrival;
			B1 = txtFirstClassService;
			B2 = txtCoachService;
			DUR = txtDuration;
		} catch (NumberFormatException e) {
			return;
		}
		int duration = 0;
		int maxQueueLengthFirstClass = 0, maxQueueLengthCoach = 0;
		// Begin simulation.
		while (duration++ < DUR) {
			Random rand = new Random();
			// Check for passengers.
			if (rand.nextDouble() < (1 / (double) A1)) {
				Passenger p = new FirstClassPassenger(duration);
				allPassengers.add(p);
				first.enQueue(p);
			}
			if (rand.nextDouble() < (1 / (double) A2)) {
				Passenger p = new Passenger(duration);
				allPassengers.add(p);
				coach.enQueue(p);
			}
			// Assign passengers to stations if passengers are waiting and
			// stations are available.
			while (!first.isEmptyQueue()) {
				Station s = getFreeStation(true);
				if (s == null)
					break;
				Passenger p = (Passenger) first.deQueue();
				int serviceTime = rand.nextInt(B1) + 1;
				p.serviceStarting(duration, serviceTime, s);
				s.servicePassenger(p, serviceTime);
			}
			while (!coach.isEmptyQueue()) {
				Station s = getFreeStation(false);
				if (s == null)
					break;
				Passenger p = (Passenger) coach.deQueue();
				int serviceTime = rand.nextInt(B2) + 1;
				p.serviceStarting(duration, serviceTime, s);
				s.servicePassenger(p, serviceTime);
			}
			// Pass one unit of time.
			for (Station s : stations)
				s.tick();
			// Check statistics.
			if (first.queueSize() > maxQueueLengthFirstClass)
				maxQueueLengthFirstClass = first.queueSize();
			if (coach.queueSize() > maxQueueLengthCoach)
				maxQueueLengthCoach = coach.queueSize();
		}
		// Print statistics.
		int totalServiceTimeCoach = 0, totalServiceTimeFirstClass = 0;
		int totalPassengersCoach = 0, totalPassengersFirstClass = 0, totalCoachPassengersAtFirstClass = 0;
		int maxServiceTimeCoach = 0, maxServiceTimeFirstClass = 0;
		int totalWaitTimeCoach = 0, totalWaitTimeFirstClass = 0;
		for (Passenger p : allPassengers) {
			if (flag)
				System.out.println(p.toString());
			if (p instanceof FirstClassPassenger)
				totalWaitTimeFirstClass += p.waitTime();
			else {
				totalWaitTimeCoach += p.waitTime();
				if (p.station != null && p.station instanceof FirstClassStation)
					totalCoachPassengersAtFirstClass++;
			}
		}
		for (Station s : stations) {
			if (flag)
				System.out.println(s.toString());
			if (s instanceof FirstClassStation) {
				totalServiceTimeFirstClass += s.totalServiceTime;
				totalPassengersFirstClass += s.passengersServiced;
				if (s.maxServiceTime > maxServiceTimeFirstClass)
					maxServiceTimeFirstClass = s.maxServiceTime;
			} else {
				totalServiceTimeCoach += s.totalServiceTime;
				totalPassengersCoach += s.passengersServiced;
				if (s.maxServiceTime > maxServiceTimeCoach)
					maxServiceTimeCoach = s.maxServiceTime;
			}
		}
		if (flag) {
			System.out.println("Average First Class Service Time: " + Double.valueOf((new DecimalFormat("#.##"))
					.format((double) totalServiceTimeFirstClass / totalPassengersFirstClass)));
			System.out.println("Average Coach Service Time: " + Double.valueOf(
					(new DecimalFormat("#.##")).format((double) totalServiceTimeCoach / totalPassengersCoach)));
			System.out.println("Max First Class Service Time: " + maxServiceTimeFirstClass);
			System.out.println("Max Coach Service Time: " + maxServiceTimeCoach);
			System.out.println("Total First Class Passengers Served: " + totalPassengersFirstClass);
			System.out.println("Total Coach Passengers Served: " + totalPassengersCoach);
			System.out.println("Total Coach Passengers Served at First Class: " + totalCoachPassengersAtFirstClass);
			System.out.println("Max First Class Queue Length: " + maxQueueLengthFirstClass);
			System.out.println("Max Coach Queue Length: " + maxQueueLengthCoach);
			System.out.println("Average First Class Wait Time: " + Double.valueOf(
					(new DecimalFormat("#.##")).format((double) totalWaitTimeFirstClass / totalPassengersFirstClass)));
			System.out.println("Average Coach Wait Time: " + Double.valueOf(
					(new DecimalFormat("#.##")).format((double) totalWaitTimeCoach / totalPassengersFirstClass)));
		}
		System.out.println(("Average Service Time at First Class Station: "
				+ Double.valueOf((new DecimalFormat("#.##"))
						.format((double) totalServiceTimeFirstClass / totalPassengersFirstClass))
				+ "\nAverage Service Time at Coach Station: "
				+ Double.valueOf(
						(new DecimalFormat("#.##")).format((double) totalServiceTimeCoach / totalPassengersCoach))
				+ "\nMaximum Service Time at First Class Station: " + maxServiceTimeFirstClass
				+ "\nMaximum Service Time at Coach Station: " + maxServiceTimeCoach
				+ "\nTotal Passengers Serviced at First Class Station: " + totalPassengersFirstClass
				+ "\nCoach Passengers Serviced at First Class Station: " + totalCoachPassengersAtFirstClass
				+ "\nTotal Passengers Serviced at Coach Station: " + totalPassengersCoach
				+ "\nMaximum Queve Length for First Class Passengers: " + maxQueueLengthFirstClass
				+ "\nMaximum Queue Length for Coach Passengers: " + maxQueueLengthCoach
				+ "\nAverage Wait Time for First Class Passengers: "
				+ Double.valueOf((new DecimalFormat("#.##"))
						.format((double) totalWaitTimeFirstClass / totalPassengersFirstClass))
				+ "\nAverage Wait Time for Coach Passengers: " + Double.valueOf(
						(new DecimalFormat("#.##")).format((double) totalWaitTimeCoach / totalPassengersFirstClass))));
	}

	private Station getFreeStation(boolean firstClassOnly) {
		if (!firstClassOnly)
			for (Station s : stations)
				if (!(s instanceof FirstClassStation) && s.isAvailable())
					return s;
		for (Station s : stations)
			if (s instanceof FirstClassStation && s.isAvailable())
				return s;
		return null;
	}
}