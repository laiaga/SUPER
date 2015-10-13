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
		if(isWaiting()){
			throw new Exception("You can't ask for a car in the state \"waiting\" to move !");
		}
		if(isGone()){
			throw new Exception("You can't ask for a car that has already finished crossing the bridge.");
		}
		else{
			int newPos = getPosition();
			newPos += getSpeed();
			setPosition(newPos);
			if(super.getPosition() > 50)
			{
				Bridge.getInstance().addBoat();
			}
			if(super.getPosition() > 480)
			{
				Bridge.getInstance().removeBoat();
			}
		}
	}

}
