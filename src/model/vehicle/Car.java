package model.vehicle;

import model.Bridge;

/**
 * @author Alexandre
 * Implementation of the Vehicle abstract class that modelizes a car
 */
public class Car extends Vehicle {

	/**
	 * Constructor of a Car
	 * @param position The position of the car along its axis
	 * @param speed The average speed of the car
	 * @param direction The direction the car is following, which can only be either East or West
	 */
	public Car(int position, int speed, Direction direction) throws Exception {
		super(position, speed, direction);
		if(direction != Direction.East && direction != Direction.West){
			throw new Exception("A car can only follow the East direction or the West direction.");
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
				Bridge.getInstance().addCar();
			}
			if(super.getPosition() > 480)
			{
				Bridge.getInstance().removeCar();
			}
		}
	}
}
