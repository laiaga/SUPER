package model.vehicle;

/**
 * Abstract modelisation of a vehicule using the bridge
 * @author Alexandre Leonardi
 */
public abstract class Vehicle {
	// True if the vehicle isn't prioritary at the moment
	private boolean waiting;
	// Position of the vehicle along the axis he is following, in m
	private int position;
	// Average speed of the vehicle, in m/s
	private int speed;
	// Direction the vehicle is following,
	private Direction direction;
	
	public boolean isWaiting() {
		return waiting;
	}
	public void setWaiting(boolean waiting) {
		this.waiting = waiting;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Vehicle(int position, int speed, Direction direction){
		waiting = false;
		this.position = position;
		this.speed = speed;
		this.direction = direction;
	}
	
	public void forward() throws Exception {
		if(isWaiting()){
			throw new Exception("You can't ask for a car in the state \"waiting\" to move !");
		}
		else{
			while(!isWaiting()){
				int newPos = getPosition();
				newPos += getSpeed();
				setPosition(newPos);
				wait(1000);
			}
		}
	}
    public void stop(){
    	setWaiting(true);
    }
}