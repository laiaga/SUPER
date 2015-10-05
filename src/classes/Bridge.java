package classes;

import java.util.HashMap;

public class Bridge
{
	private PositionBridge state;
	private HashMap<Integer, Sensor> sensors;

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
