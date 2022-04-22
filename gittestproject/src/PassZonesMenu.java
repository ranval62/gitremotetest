import java.io.BufferedReader;
import java.io.IOException;

public class PassZonesMenu {
	
	private BufferedReader bz;
	
	PassZonesMenu(BufferedReader br) {
		bz = br;
	}

	
	public char setTravelZone(BufferedReader br) throws IOException
	{

		char zone;
   
		System.out.println("*******   Set Pass Travel Zones   ***********");
		System.out.println(); 							// blank line
		System.out.println("Which Travel Zone: ");
		System.out.println("a) Zone 1");
		System.out.println("b) Zones 1 & 2");
		System.out.println("c) cancel");
		System.out.println("*********************************************");
		System.out.println();                        	// blank line		
		System.out.print("Your selection : ");			// enter the Zone option required

		do {
			System.out.println("zone is: ");
			zone = (char) bz.read();
			if (zone == 'a') {
			   System.out.println("Zone 1 selected");
			   return zone;
			}
			else if (zone == 'b') {
				System.out.println("Zone 1+2 selected");
				return zone;
			}
			else if (zone == 'c') System.out.println("Cancel the pass purchase ");
		}	while (zone != 'c');
		return zone;
	}
	

}
