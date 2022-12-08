/**
 * This class is used to keep track of the details of the plane objects, their distance, plane number, time on the runway, and whether or not it is an emergency
 * @author James Frayser
 * @version 12/7/2022
 */
public class Plane implements Comparable<Plane> 
{
	/**
	 * methods
	 */
	private int timeOnRunway;
	private boolean onRunway;
	private int planeNumber;
	private boolean emergency;
	private int distanceTraveled;
	
	/**
	 * preferred argument constructor
	 */
	public Plane()
	{
		timeOnRunway = 15;
		onRunway = false;
		planeNumber = 100 + (int)(Math.random()*(1000));
		emergency = false;
		distanceTraveled = 110;
		
	}
	/**
	 * gets the time on the runway
	 * @return: an int with the time spent on the runway
	 */
	public int getTimeOnRunway() {
		return timeOnRunway;
	}

	/**
	 * sets how long the plane is on the runway
	 * @param timeOnRunway
	 */
	public void setTimeOnRunway(int timeOnRunway) {
		this.timeOnRunway = timeOnRunway;
	}

	/**
	 * Lets you know that the plane is on the runway or not
	 * @return: a boolean indicating the plane being on the runway or not, true if it is and false if it is not 
	 */
	public boolean isOnRunway() {
		return onRunway;
	}

	/**
	 * sets whether or not the plane is on the runway
	 * @param onRunway
	 */
	public void setOnRunway(boolean onRunway) {
		this.onRunway = onRunway;
	}

	/**
	 * gets the planes number 
	 * @return and int that is the plane's number 
	 */
	public int getPlaneNumber() {
		return planeNumber;
	}

	/**
	 * sets the plane's number 
	 * @param planeNumber
	 */
	public void setPlaneNumber(int planeNumber) {
		this.planeNumber = planeNumber;
	}

	/**
	 * Uses math.random to determine if the plane is having an emergency or not
	 * @return a boolean, true if it is an emergency, false if not
	 */
	public boolean isEmergency() 
	{
		int isEmergency = (int)(Math.random()*((100)+1));
		
		if(isEmergency >= 99) 
		{
			emergency=true;
		}
		
		return emergency;
	}

	/**
	 * sets if there is an emergency
	 * @param emergency
	 */
	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
	}

	/**
	 * gets the total distance traveled by the plane
	 * @return and int: displaying the distance traveled
	 */
	public int getDistanceTraveled() {
		return distanceTraveled;
	}

	/**
	 * sets the travel distance
	 * @param distanceTraveled
	 */
	public void setDistanceTraveled(int distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}
	/**
	 * updates the plane every tick, -10 from the distance traveled to make it so that it is approaching the airport, and
	 * -5 while on the runway to get it off the runway soon.
	 */
	public void status()
	{
		distanceTraveled = distanceTraveled - 10;
		if(onRunway)
		{
			timeOnRunway = timeOnRunway - 5 ;
		}	
	}
	
	/**
	 * Determines if the plane is having an emergency or not, displaying distance as well
	 * @return an int: whether or not a plane is of priority or not + distance
	 */
	public int priority() {
		return isEmergency()? distanceTraveled -1 :distanceTraveled;
	}

	/**
	 * compares 1 plane to another to determine priority
	 */
	public int compareTo( Plane p )
	{
		return priority()- p.priority();
	}

	/**
	 * prints the necessary data int the application class
	 */
	@Override
	public String toString() 
	{ 
			{
				if(emergency) 
				{
					return"   EMREGENCY     " + planeNumber + "   |        " +  distanceTraveled + "        ";
				}
				else 
				{
					return "           " + planeNumber + "           |        " + distanceTraveled + "        ";
				}
			}
	}
	
}//end class