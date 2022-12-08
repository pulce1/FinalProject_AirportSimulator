/**
 * This class is used to keep track of the details Airport and runways, and assigning planes to runways
 * @author James Frayser
 * @version 12/7/2022
 */
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Airport 
{
	/**
	 * methods
	 */
	private Queue<Plane> incoming;
	private PriorityQueue<Plane> readyToLand;
	private Plane[] runways;
	
	/**
	 * preferred argument constructor
	 */
	public Airport() 
	{
		incoming = new PriorityQueue<>();
		readyToLand = new PriorityQueue<>();
		runways = new Plane[4];
	}
	
	
	/**
	 * generates a number, if the number is bigger than the 50, then a plane is added to the queue
	 */
	public void addIncoming() 
	{
		int planeInAir = (int)(Math.random()*(100));
		if(planeInAir >= 65) {
			Plane airPlane=new Plane();
			incoming.add(airPlane);
		}
	}
	
	/**
	 * prints out the planes on the runway, which runway they are on, and the time spent on the runway
	 */
	public void printOnRunway() 
	{
		for(int i = 0; i < runways.length; i++) 
		{
			if (runways[i] != null) 
			{
					if(runways[i].isEmergency()==true) 
					{
						System.out.println("| " + (i + 1) + "     |     " + runways[i].getPlaneNumber() + " EMERGENCY  |            " + runways[i].getTimeOnRunway()+ "           |");
					}
					else {
						System.out.println("| " + (i + 1) + "     |     " + runways[i].getPlaneNumber() + "     |            " + runways[i].getTimeOnRunway()+ "           |");
					}
				}		
			}
	}
	
	/**
	 * allows for you in the app to call printScreen and have 2 different prints happen, depending on the state of the plane
	 */
	public void printScreen() 
	{
		System.out.println("Planes to Land(Plane NUM)|  Distance from Runway  ");
		for (Plane plane : incoming) 
		{			
			System.out.println( plane );
		}
		for (Plane plane: readyToLand) {			
			System.out.println("              " +  plane  + "              ");
		}
		System.out.println(" \nRunway# |    Plane   | Time Spent on the runway ");
		printOnRunway();
	}

	/**
	 * updates the plane, moving it when the distance reaches 0, and putting in onto an available runway
	 */
	public void status() 
	{
		addIncoming();
		
		for (Plane plane : incoming) 
		{
			plane.status();
		}
		while( incoming.peek()!= null &&incoming.peek().getDistanceTraveled() <= 0) 
		{
			readyToLand.add(incoming.poll());
		}
		
		for(Plane plane:readyToLand) 
		{
			plane.status();
		}
		
		for(int j=0 ; j<runways.length; j++) 
		{
			if(runways[j]==null) 
			{
				runways[j]=readyToLand.poll();
				if (runways[j] != null) 
				{					
					 runways[j].setOnRunway( true );
				}
			}
			else 
			{
				runways[j].status();
				if(runways[j].getTimeOnRunway() <= 0) 
				{
					runways[j]=null;
				}
			}
		}
	}
	public static void clear()

    {
        try
        {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}//end class