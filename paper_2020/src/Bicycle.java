
public class Bicycle {
	
	public int identifier;
	public String type;
	public boolean available;
	
	public Bicycle(int identifier, String type) {
		this.identifier = identifier;
		this.type = type;
		this.available = true;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setRentable(boolean available) {
		this.available = available;
	}

	public int getIdentifier() {
		return identifier;
	}

	public String getType() {
		return type;
	}

}
