package model;

import java.util.HashMap;

public class Bridge
{
	private PositionBridge state;
	private HashMap<Integer, Sensor> sensors;
	private int nbCars;
	private int nbBoats;
	
	private Bridge()
	{
		state = PositionBridge.Down;
		nbBoats = nbCars = 0;
	}
	
	private static class BridgeHolder
	{		
		/** Instance unique non préinitialisée */
		private final static Bridge instance = new Bridge();
	}
 
	/** Point d'accès pour l'instance unique du singleton */
	public static Bridge getInstance()
	{
		return BridgeHolder.instance;
	}
	
	public void addCar()
	{
		nbCars += 1;
	}
	
	public void removeCar()
	{
		nbCars -= 1;
	}
	
	public void addBoat()
	{
		nbBoats += 1;
	}
	
	public void removeBoat()
	{
		nbBoats -= 1;
	}
	
	public boolean isThereCars()
	{
		return nbCars != 0;
	}
	
	public boolean isThereBoats()
	{
		return nbBoats != 0;
	}

	public PositionBridge getState()
	{
		return this.state;
	}
	public Sensor getSensor(int key)
	{
		return this.sensors.get(key);
	}
	

	public void up()
	{
		if(this.state == PositionBridge.Down)
		{
			this.state = PositionBridge.Moving;
			try {
				wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.state = PositionBridge.Up;
		}
	}
	public void down()
	{
		if(this.state == PositionBridge.Up)
		{
			this.state = PositionBridge.Moving;
			try {
				wait(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.state = PositionBridge.Down;
		}
	}
}
