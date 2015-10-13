package model;

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
		barrierEast = new Barrier(0);
		barrierEast = new Barrier(0);
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
	
	public boolean isThereCars()
	{
		return sensorCars.getState();
	}
	
	public boolean isThereBoats()
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
