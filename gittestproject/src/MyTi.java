import java.io.*;
import java.util.*;
import java.util.zip.DataFormatException;

public class MyTi {
	
	private int ID;
	private double credit;
	private ArrayList<TravelPass> pass_list = new ArrayList<TravelPass>();
	


    MyTi (int ID, double credit, ArrayList<TravelPass> plist) {
    	
	this.ID=ID;					// My Ticket ID
	this.credit = credit;		// My Ticket credit
	this.pass_list = plist;
	}

    /* Accessor methods */
    int getID() { return ID; }
    double getCredit() { return credit; }
	public ArrayList<TravelPass> getPassList() { return pass_list; }
	/* Set methods */
	public void setPassList(ArrayList<TravelPass> plist) {this.pass_list = plist;}

    
    /* Print My Ticket Information */
    public void printMyTi()
    {
    	System.out.print("ID = " + ID);
 	   	System.out.print(" Credit  = " + credit);
 	   	System.out.println();
    }
		
	public void dispPassList(ArrayList<TravelPass> pl) {
		
		if (pl.size() > 0) 
			System.out.println("Pass List: " + pl);
		else
			System.out.println("No passes have been purchased");
		
	}
	
   public ArrayList<TravelPass> listPasses(ArrayList<TravelPass> l) {  // List of travel passes by ticket
   		   
   		   ArrayList<TravelPass> list = new ArrayList<>();

   		   for (int i = 0; i < l.size(); i++) 
   	 		   list.add(l.get(i)); 
   		   for (int j = 0; j < list.size(); j++) { list.get(j).showTravelPass();}
   		   return list;
   	   } 


		 
	public boolean creditTooLow(double pass_cost)
	{
		double c_balance;
		boolean balTooLow = false;
			 
		c_balance = getCredit();		// get MyTi credit balance
		if (c_balance < pass_cost) 	// 
		{
			System.out.print("Warning: credit on account too low for order:  ");
			System.out.printf("%.2f", c_balance);
			System.out.print(" less than order ");
			System.out.printf("%.2f", pass_cost);
			System.out.println();
			balTooLow = true;
		} 
		return balTooLow;
			 
	}
	
	public double chargeMyTi(BufferedReader br) throws IOException {
		
		// String amt;
		System.out.println(" Current credit balance: " + getCredit());
		System.out.println("Enter charge amount (less than $100 credit allowed): ");
		
		double charge = 0.0;
		String amt = br.readLine();
		System.out.println("Amount: " + amt);
		// convert from string to double format
		// credit_charge = Double.parseDouble(amt);
		try { charge = Double.parseDouble(amt); }
		catch(NumberFormatException exc) {
			System.out.println("Invalid credit charge amount: ");
			charge = 0.0;
		} 
		if (charge%5.00 != 0.0) {
			System.out.print("Charge amounts must be in multiples of $5.00 - check amount entered: $");
			System.out.printf("%.2f",charge);
			System.out.println();
			System.out.println("Return to main menu and try again ");
			return 0.0;
		}
		return charge;
	}
		
	
	public double creditCharge(double charge, double max_balance) {
		double c_balance;
		double new_balance;
		boolean balTooHigh = false;
			 
		c_balance = getCredit();			// get MyTi credit balance
		new_balance = c_balance + charge;	// add the charge amount to the credit balance
		if (new_balance > max_balance) 			// 
		{
			System.out.println("Warning: credit on account too high for charge amount. Current balance:  " + c_balance + " charge amount: " + charge + " Total is: " + new_balance);
			balTooHigh = true;
		} 
		
		if (balTooHigh) {
			return c_balance; // amount of charge was too high to stay below the credit maximum
		} else {
			return new_balance;
		}
			 
	}
	
	
	public void dispCreditBalance() {					// display credit balance
	
		double c_balance;
			 
		c_balance = getCredit();						// get MyTi credit balance
		System.out.print("Current credit balance:  ");
		System.out.printf("%.2f", c_balance);			// Print in decimal format
		System.out.println();
		
	}
	
	public double reduceCreditBalance(double pass_cost) {
		
		double bal;
		bal = getCredit();
		if (bal > pass_cost)
		   bal -= pass_cost;
		else {
			System.out.print("Balance of credit: $");
			System.out.printf("%.2f", bal);
			System.out.print(" is less than pass cost: $");
			System.out.printf("%.2f", pass_cost);
			System.out.println();
		}
		return bal;
	}
	
/*
	public char setTravelZone(BufferedReader br) throws IOException
	{

		char zone;
   
		System.out.println("*******   Travel Zone   ***********");
		System.out.println(); 							// blank line
		System.out.println("Which Travel Zone: ");
		System.out.println("a) Zone 1");
		System.out.println("b) Zones 1 & 2");
		System.out.println("c) cancel");
		System.out.println("**********************");
		System.out.println();                        	// blank line		
		System.out.print("Your selection : ");			// enter the Zone option required

		do {
			System.out.println("zone is: ");
			zone = (char) br.read();
			if ((zone == 'a') || (zone == 'b')) {
			System.out.println("entred zone is: " + zone);
			return zone;
			}
		}	while (zone != 'c');
		return zone;
	}
	
	public char setTimePeriod(BufferedReader br) throws IOException
	{

		char resp;
 
		System.out.println("*******   Time Period   ***********");
		System.out.println(); 						// blank line
		System.out.println("What Time Period: ");
		System.out.println("a) 2 Hours");
		System.out.println("b) All Day ");
		System.out.println("c) cancel");
		System.out.println("**********************");
		System.out.print("Your choice : ");

		do {
			System.out.println("time period is");

			resp = (char) br.read();
			System.out.println(resp);
			if (resp == 'a') return resp;
			else if (resp == 'b') return resp;
		}	while (resp != 'c');
			return resp;
	}
*/	

	public int menuAndInput(BufferedReader br) throws IOException {

		String resp;
		int choice;
			
		System.out.println();
		System.out.println("*******   MyTi Main Menu   ***********");
		System.out.println(); 								// blank line
		System.out.println("Buy Travel Pass     1 ");
		System.out.println("Charge MyTi         2 ");
		System.out.println("Display MyTi Credit 3 ");
		System.out.println("Print purchases     4 ");
		System.out.println("Exit                0 ");
		System.out.println("***************************************");
		System.out.print("Your choice : ");

		do {
			resp = (String) br.readLine(); 			
//			System.out.println("resp " + resp);					// debug statement
			try { choice  =  Integer.parseInt(resp); }
			catch(NumberFormatException exc) {
				System.out.println("Invalid choice entered");
				choice = -1;
			}
		} while (choice < 0 || choice > 4);
		return choice;
			
	}	
	
	public void control() throws IOException
	{
	   // initialize();	   
	   int choice;
	   ArrayList<TravelPass> passes = new ArrayList<TravelPass>();
	   System.out.println("control");
	   
	   try (BufferedReader br = new BufferedReader( new InputStreamReader(System.in))) {  // Java: A Beginners Guide p.364


	   do {
	       choice = menuAndInput(br);  
	       if (choice == 1)
	       {
//	    	   char t = setTimePeriod(br); 
	    	   TimePeriodMenu tp = new TimePeriodMenu(br);
	    	   char t = tp.setTimePeriod(br);
	    	   System.out.println("period " + t);
	    	   
	    	   PassZonesMenu zm = new PassZonesMenu(br);
	    	   char z = zm.setTravelZone(br);
	    	   System.out.println("zone type is: " + z);
	    	   // Pass Type
	    	   String time = Character.toString(t);				// https://www.javatpoint.com/java-char-to-string
	    	   String period = Character.toString(z);			// https://www.javatpoint.com/java-char-to-string
	    	   String pass_type = time + period;
	    	   // Create Travel Pass based on pass type. Use case to allow for easy adding of passes in future 
	    	   switch(pass_type) {
	    	   case "aa":  // 2 Hours Zone 1 Pass
	    		   if (!creditTooLow(2.50)) {					// check there is enough credit to buy the pass
    			      System.out.println("Pass 2 Hours Z1");
    			      SingleZonePass s1 = new SingleZonePass ("2HZ1", "2H", 2.50, "Z1",  "2 Hour Zone 1 ");
    			      s1.showTravelPass();
    			      credit = reduceCreditBalance(2.50);		// new credit balance
    			      passes.add(s1);							// add pass to pass list / history
	    		   }
    			   break;
	    	   case "ab":  // 2 Hours Zone 1+2 (Multizone) Pass
	    		   if (!creditTooLow(3.50)) {					// check there is enough credit to buy the pass
	    		      System.out.println("Pass 2 Hours Zone 1 + 2 pass ");
	    		      SingleZonePass sm = new SingleZonePass ("2HZ1+2", "2H", 3.50, "Z1+2",  "2 Hour Zone 1+2 ");
	    		      sm.showTravelPass();
	    		      credit = reduceCreditBalance(3.50);		// new credit balance
		    		  passes.add(sm);							// add pass to pass list / history
		    		   }
	    		   break;
		       case "ba":  // All Day Zone 1 Pass
	    		    if (!creditTooLow(4.90)) {					// check there is enough credit to buy the pass
		    	       System.out.println("Pass All Day Zone 1 pass ");
		    		   MultiZonePass m1 = new MultiZonePass ("ADZ1", "AD", 4.90, 1, 2,  "All Day Zone 1 ");
		    		   m1.showTravelPass();
		    		   credit = reduceCreditBalance(4.90);		// new credit balance
		    		   passes.add(m1);							// add pass to history / list of passes
	    		    }
		    		break;
		    	case "bb": // All Day Zone 1+2 (Multizone) Pass
		    		if (!creditTooLow(6.80)) {					// check there is enough credit to buy the pass
		    		   System.out.println("Pass All Day Zone 1 + 2 pass ");
		    		   MultiZonePass mm = new MultiZonePass ("ADZM", "AD", 6.80, 1, 2,  "All Day MultiZones Pass ");
		    		   mm.showTravelPass();
		    		   credit = reduceCreditBalance(6.80);		// new credit balance
		    		   passes.add(mm);							// add pass to pass list / history
		    		}
		    		break;
	    		}
	    	}
	       else if (choice == 2) {
	    	   System.out.println("Charge MyTi         2 ");
	           double ch = chargeMyTi(br);
	           if (ch > 0) {
	        	   System.out.println("Old credit balance: " + credit);
	        	   credit = creditCharge(ch, 100);
	        	   System.out.println("New balance: " + credit);
	           }
	       }
	       
	       else if (choice == 3) {
	    	   System.out.println("Display MyTi Credit 3 ");
	           dispCreditBalance();
	       }
	       else if (choice == 4 ) {
	    	   dispPassList(passes);
	    	   listPasses(passes);
	       }
	       
	       // Exit the main menu;
	       else if (choice == 0)
	    	   System.out.println("Exit                0 ");
	    	   // replenishStock();
	   } while (choice != 0);  
	} catch (NumberFormatException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
//	br.close(); 
	}
	

	
	public static void main(String[] args) throws IOException 
	{

		
		int id = 1;
		double credit = 0;
		ArrayList<TravelPass> passes = null;
		MyTi m = new MyTi(id, credit, passes);	

		m.control();		
		System.out.println(" End of Program");
		
		
	}	
	
	
}
	
