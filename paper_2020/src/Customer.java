import java.time.Duration;
import java.time.Instant;

public class Customer {
	
	public boolean renting = false;
	public Bicycle bikeRenting = null;
	public Instant rentStarted;
	public Instant rentEnded;
	
	void rentBike(Bicycle bike) throws IllegalArgumentException {
		if (bike.available) {
			if (!this.renting) {
				this.renting = true;
				this.bikeRenting = bike;
				rentStarted = Instant.now();
			}
			else {
				throw new IllegalArgumentException();
			}
		}
		else {
			throw new IllegalArgumentException();
		}
	}
	
	double endRental() {
		this.renting = false;
		this.bikeRenting = null;
		rentEnded = Instant.now();
		double difference = Duration.between(rentStarted, rentEnded).toHours();
		return difference;
		
		
	}
	
	public static final void main(String[] args) {
		
		Bicycle b = new Bicycle(1, "road bike");
		Customer c = new Customer();
		c.rentBike(b);
		try {
			c.rentBike(b);
		} catch(Exception e) {
			System.out.println(e);
		}

	}

}
