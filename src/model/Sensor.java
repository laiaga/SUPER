package model;

/**
 * @author Loïc Vierin
 *
 */
public class Sensor 
{

	private boolean state;
	private int position;

	
	public Sensor(int position)
	{
		this.state = false;
		this.position = position;
	}

	public boolean getState()
	{
		return this.state;
	}

	public int getPosition()
	{
		return this.position;
	}

	public void setState(boolean state)
	{
		this.state = state;
	}



}