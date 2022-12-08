/**
 * This class uses the Plane and Airport classes to make a simulation of an airport, and uses a timer to automatically go through the motions, as well as printing each time it ticks
 * @author James Frayser
 * @version 12/7/2022
 */
import java.util.TimerTask;
import java.util.Timer;

public class Application 
{
	public static void main(String[] args) 
	{
	
		/**
		 * creates the airport and timer, where it is called on to be printed by using airport.status/printScreen
		 */
		Airport airport = new Airport();
		Timer timer = new Timer();
		
		TimerTask timerTask = new TimerTask() 
		{
			
			int p=1;
			public void run() {
				
				airport.status();
				airport.printScreen();
				System.out.println("\nTime Elapsed: " + p*5);
				p++;
			}
			
		};
		
		/**
		 * represents the automatically ticking timer, as well as its speed
		 */
		timer.scheduleAtFixedRate(timerTask, 0, 3000);
	 
	}//end main

}//end class