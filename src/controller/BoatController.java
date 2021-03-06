package controller;

import java.io.IOException;

import model.BicolorLight;
import model.Bridge;
import model.ColorLights;
import model.PositionBridge;
import model.vehicle.*;
import view.Boat;
import view.Car;
import view.Position;
import view.View;

/**
 * @author Ghislain Dugat, Abdelkader Benameur, Guélaud Lepetit
 *
 */
public class BoatController implements Runnable
{
	
	private View window;
	
	/**
	 * @param window
	 */
	public BoatController(View window)
	{
		this.window = window;
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				model.vehicle.Boat boatNorth = new model.vehicle.Boat(0, 50, Direction.South);
				Boat boatNorthView = window.createBoat(Position.NORTH);
				model.vehicle.Boat boatSouth = new model.vehicle.Boat(0, 50, Direction.North);
				Boat boatSouthView = window.createBoat(Position.SOUTH);
				if(!(Bridge.getInstance().getState() == PositionBridge.Up
						&& Bridge.getInstance().getLightNorth().getFeux() == ColorLights.VERT && Bridge.getInstance().getLightSouth().getFeux() == ColorLights.VERT))
				{
					synchronized (Thread.currentThread())
					{
						Thread.currentThread().wait();
					}										
				}
				MoveBoatController moveBoatNorth = new MoveBoatController(boatNorth, boatNorthView);
				Thread threadBoatNorth = new Thread(moveBoatNorth);
				MoveBoatController moveBoatSouth = new MoveBoatController(boatSouth, boatSouthView);	
				Thread threadBoatSouth = new Thread(moveBoatSouth);
				threadBoatNorth.start();
			    synchronized (Thread.currentThread())
				{
					try
					{
						Thread.currentThread().wait(100);
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				threadBoatSouth.start();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (Thread.currentThread())
			{
				try
				{
					Thread.currentThread().wait(2000);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
