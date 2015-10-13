package controller;

import java.awt.Point;

import model.vehicle.Boat;
import model.vehicle.Direction;

public class MoveBoatController implements Runnable
{
	
	private Boat boat;
	private view.Boat boatView;
	
	public MoveBoatController(Boat boat, view.Boat boatView)
	{
		this.boat = boat;
		this.boatView = boatView;
	}
	
	public void run()
	{
		while(boat.getPosition() < 761)
		{
			try
			{
				boat.forward();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			boatView.move(boat.getSpeed());
			synchronized (Thread.currentThread())
			{
				try
				{
					Thread.currentThread().wait(1000);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		boatView.hide();
	}

}
