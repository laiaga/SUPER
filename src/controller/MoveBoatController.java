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
		
	}

}
