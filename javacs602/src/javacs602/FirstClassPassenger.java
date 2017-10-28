package javacs602;

public class FirstClassPassenger extends Passenger {
	 public FirstClassPassenger(int arrivalTime) {
	 super(arrivalTime);
	 }
	 @Override
	 public String toString() {
	 if (station == null)
	 return "Passenger " + number + " - First Class - Arrival Time: " + arrivalTime + " - NOT	SERVICED";
	 else
	 return "Passenger " + number + " - First Class - Arrival Time: " + arrivalTime + " - Service	Starting Time: " + serviceStartingTime + " - Service Time: " + serviceTime + " - Station type: " +
	station.toString();
	 }

	 } 
