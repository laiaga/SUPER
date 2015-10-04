/**
 * 
 */
package model;

/**
 * @author Alexandre Leonardi
 *
 */
public abstract class Vehicle {
	private boolean waiting;
	private int position;
	private int speed;
	private char direction;
	
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
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}

    public void forward(){
    }

    public void backward(){
    }

    public void stop(){
    }
}
