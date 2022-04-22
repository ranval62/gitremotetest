import java.io.BufferedReader;
import java.io.IOException;

public class TimePeriodMenu {

	private BufferedReader b;
	
	TimePeriodMenu(BufferedReader br) {
		b = br;
	}
	
	
	public char setTimePeriod(BufferedReader br) throws IOException
	{

		char resp;
 
		System.out.println("*******   Set Pass Time Period   ***********");
		System.out.println(); 						// blank line
		System.out.println("What Time Period: ");
		System.out.println("a) 2 Hours");
		System.out.println("b) All Day ");
		System.out.println("c) cancel");
		System.out.println("*********************************************");
		System.out.print("Your choice : ");

		do {
			System.out.println("time period is");

			resp = (char) b.read();
			System.out.println(resp);
			if (resp == 'a') return resp;
			else if (resp == 'b') return resp;
		}	while (resp != 'c');
		return resp;
	}	
	
}
