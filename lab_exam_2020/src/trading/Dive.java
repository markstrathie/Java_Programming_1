package trading;

public class Dive {
	
	private double flips;
	private FlightPosition flightPosition;
	private double twists;
	private Approach approach;
	
	public Dive(double flips, FlightPosition flightPosition, double twists, Approach approach)
	throws IllegalArgumentException {
		
		this.flightPosition = flightPosition;
		this.approach = approach;
		
		if (validateFlipsOrTwists(flips)) {
			this.flips = flips;
		}
		else {
			throw new IllegalArgumentException("Flips are invalid");
		}
		
		if (validateFlipsOrTwists(twists)) {
			this.twists = twists;
		}
		else {
			throw new IllegalArgumentException("Twists are invalid");
		}
		
	}

	public double getFlips() {
		return flips;
	}

	public FlightPosition getFlightPosition() {
		return flightPosition;
	}

	public double getTwists() {
		return twists;
	}

	public Approach getApproach() {
		return approach;
	}
	
	public boolean validateFlipsOrTwists(double flipOrTwist) {
		
		if (flipOrTwist < 0.0) {
			return false;
		}
		else if (flipOrTwist > 4.0) {
			return false;
		}
		else if ((flipOrTwist / 0.5) != 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public double computeDifficulty() {
		
		double flightPositionPoints = 0;
		double approachPoints;
		double flipPoints;
		double twistPoints;
		double difficulty;
		
		switch(flightPosition) {
			case TUCKED:
				flightPositionPoints = 0.0;
				break;
			case PIKED:
				flightPositionPoints = 0.5;
				break;
			case STRAIGHT:
				flightPositionPoints = 1.0;
				break;
		}
		
		switch(approach) {
			
			case FORWARD:
				approachPoints = 0.0;
				break;
			case BACKWARD:
				approachPoints = 0.2;
				break;
			case INWARD:
				approachPoints = 0.3;
				break;
			case REVERSE:
				approachPoints = 0.3;
				break;
		}
	
		if (flips == 0) {
			flipPoints = 1.0;
		} else {
			flipPoints = (flips / 0.5)*0.3;
		}
		
		if (twists == 0) {
			twistPoints = 0.0;
		} else {
			twistPoints = (twists / 0.5)*0.1;
		}
		
		difficulty = flipPoints + twistPoints + approachPoints + flightPositionPoints;
		return difficulty;
			
	}
	
	public double totalDivesDifficulty(List<Dive> diveList) {
		
		double total = 0.0;
		
		for (Dive dive : diveList) {
			total += dive.computeDifficulty();
		}	
	}
	
}
