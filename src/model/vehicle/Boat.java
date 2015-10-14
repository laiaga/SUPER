package model.vehicle;

import model.Bridge;

/**
 * @author Alexandre
 * Implementation of the Vehicle abstract class that modelizes a boat
 */
public class Boat extends Vehicle {

	/**
	 * Constructor of a Boat
	 * @param position The position of the car along its axis
	 * @param speed The average speed of the car
	 * @param direction The direction the car is following, which can only be either East or West
	 */
	public Boat(int position, int speed, Direction direction) throws Exception {
		super(position, speed, direction);
		if(direction != Direction.North && direction != Direction.South){
			throw new Exception("A boat can only follow the North direction or the South direction.");
		}
	}

	@Override
	public void forward() throws Exception {
		if(isWaiting())
		{
			throw new Exception("You can't ask for a boat in the state \"waiting\" to move !");
		}
		else
		{
			int newPos = getPosition();
			newPos += getSpeed();
			setPosition(newPos);
			if(super.getPosition() >= super.getSpeed())
			{
				if(!super.isEntered())
				{
					Bridge.getInstance().addBoat();
				}
				super.setEntered(true);
			}
			if(super.getPosition() > 400)
			{
				if(!super.isGone())
				{
					Bridge.getInstance().removeBoat();
				}
				super.setGone(true);
			}
		}
	}

}
