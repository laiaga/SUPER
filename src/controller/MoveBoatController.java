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
			moveBoatView(boatView, boat.getSpeed());
		}
		boatView.hide();
	}
	
	private void moveBoatView(view.Boat boatView, int x)
	{
		int delta = x / 20;
		while(x > delta)
		{
			boatView.move(delta);
			x -= delta;
			synchronized (Thread.currentThread())
			{
				try
				{
					Thread.currentThread().wait(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
