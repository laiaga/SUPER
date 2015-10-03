package classes;

/**
 * @author Loïc Vierin
 *
 */
public class Barrier
{

	private boolean state;
	private int position;

	
	public Barrier(int position)
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
	
	public void up()
	{
		if(this.state == false)
			this.state = true;
		else
			System.out.println("Barrier already up");
	}
	
	public void down()
	{
		if( this.state == true)
			this.state = false;
		else
			System.out.println("Barrier already down");
	}

}
