public abstract class TravelPass {
	
	private String ID;
	private String time;
	private double price;
	
	// Constructor for Customer using two parameters for id and price
	TravelPass (String id, String t, double p) {
		this.ID = id;
		this.time = t;
		this.price = p;
	}

	//  Accessor methods for ID and price 
	String getID() { return ID; }
	String getTime() { return time; }
	double getPrice() { return price; }
	
	// abstract method for customer discounts
	abstract String getName();
	abstract void showTravelPass();
	
}

class SingleZonePass extends TravelPass	{
	
	private String zone;
	private String name;				// Pass name
	
	// Constructor for the 2 Hour Zone 1 class object
	SingleZonePass (String id, String t, double p, String z,  String n)	{
		super(id,t, p);
		zone = z;
		name = n;
	}
	
	// Accessor methods for ID, price and rate
	String getID() { return super.getID(); }
	String getTime() { return super.getTime(); }
	double getPrice() { return super.getPrice(); }
	String getZone() { return zone; }
	String getName() { return name; }	

	
	// Display SingleZonePass
	void showTravelPass() {
		System.out.print(" You purchased " + getName() + ", costing $");
		System.out.printf("%.2f", getPrice());	
		System.out.println();
	}
	
}

class MultiZonePass extends TravelPass	{
	
	private int start_zone;				// Starting zone for travel on the pass
	private int end_zone;
	private String name;				// Pass name
	
	// Constructor for the 2 Hour Zone 1 class object
	MultiZonePass (String id, String t, double p, int z1, int z2, String n)	{
		super(id,t, p);
		start_zone = z1;
		end_zone = z2;
		name = n;
	}
	
	// Accessor methods for ID, price and rate
	String getID() { return super.getID(); }
	String getTime() { return super.getTime(); }
	double getPrice() { return super.getPrice(); }
	int getStartZone() { return start_zone; }
	int getEndZone() { return end_zone; }
	String getName() { return name; }	
	
	
	// Display MultiZonePass
	void showTravelPass() {
		System.out.print(" You purchased " + getName() + ", costing $");
		System.out.printf("%.2f", getPrice());	
		System.out.println();
	}
	
}