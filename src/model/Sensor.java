package model;

/**
 * @author Loïc Vierin
 *
 */
public class Sensor 
{

	private boolean state;

	
	public Sensor()
	{
		this.state = false;
	}

	public boolean getState()
	{
		return this.state;
	}

	public void setState(boolean state)
	{
		this.state = state;
	}
}