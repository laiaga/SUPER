package model;

import view.Position;

/**
 * @author Loïc Vierin
 *
 */
public class Barrier
{

	private boolean state;
	private Position position;

	
	public Barrier(Position position)
	{
		this.state = false;
		this.position = position;
	}

	public boolean getState()
	{
		return this.state;
	}

	public Position getPosition()
	{
		return this.position;
	}

	public void setState(boolean state)
	{
		this.state = state;
	}
	
	public void up()
	{
		if(this.state == false)
			this.state = true;
	}
	
	public void down()
	{
		if(this.state == true)
			this.state = false;
	}

}
