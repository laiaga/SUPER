package model;

import view.Position;

public class Bridge
{
	private PositionBridge state;
	private int nbCars;
	private int nbBoats;
	private Sensor sensorCars;
	private Sensor sensorBoats;
	private Barrier barrierEast;
	private Barrier barrierWest;
	private TricolorLight lightEast;
	private TricolorLight lightWest;
	private BicolorLight lightNorth;
	private BicolorLight lightSouth;
	
	
	private Bridge()
	{
		state = PositionBridge.Down;
		sensorCars = new Sensor();
		sensorBoats = new Sensor();
		barrierEast = new Barrier(Position.EAST);
		barrierWest = new Barrier(Position.WEST);
		lightEast = new TricolorLight(ColorLights.VERT);
		lightWest = new TricolorLight(ColorLights.VERT);
		lightNorth = new BicolorLight(ColorLights.ROUGE);
		lightSouth = new BicolorLight(ColorLights.ROUGE);
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
		if(nbCars > 0)
		{
			sensorCars.setState(true);
		}
	}
	
	public void removeCar()
	{
		nbCars -= 1;
		if(nbCars < 1)
		{
			sensorCars.setState(false);
		}
	}
	
	public void addBoat()
	{
		nbBoats += 1;
		if(nbBoats > 0)
		{
			sensorBoats.setState(true);
		}
	}
	
	public void removeBoat()
	{
		nbBoats -= 1;
		if(nbBoats < 1)
		{
			sensorBoats.setState(false);
		}
	}
	
	public boolean areThereCars()
	{
		return sensorCars.getState();
	}
	
	public boolean areThereBoats()
	{
		return sensorBoats.getState();
	}

	public PositionBridge getState()
	{
		return this.state;
	}
	

	public Barrier getBarrierEast()
	{
		return barrierEast;
	}

	public Barrier getBarrierWest()
	{
		return barrierWest;
	}

	public TricolorLight getLightEast()
	{
		return lightEast;
	}

	public TricolorLight getLightWest()
	{
		return lightWest;
	}

	public BicolorLight getLightNorth()
	{
		return lightNorth;
	}

	public BicolorLight getLightSouth()
	{
		return lightSouth;
	}

	public void setState(PositionBridge newPos)
	{
		this.state = newPos;
	}
}
