//Package
package engine;
//Class
public class Distance 
{   
	//instance variables
	private String from;
	private String to;
	private int distance;
	//Constructor
	public Distance(String from, String to, int distance) 
	{
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
	//Distance Getters
	public String getFrom() 
	{
		return this.from;
	}
	public String getTo() 
	{
		return this.to;
	}
	public int getDistance() 
	{
		return this.distance;
	}
}