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

public class BoatController implements Runnable
{
	
	private View window;
	
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
				if(Bridge.getInstance().getState() == PositionBridge.Up
						&& Bridge.getInstance().getLightNorth().getFeux() == ColorLights.VERT && Bridge.getInstance().getLightSouth().getFeux() == ColorLights.VERT)
				{
					model.vehicle.Boat boatNorth = new model.vehicle.Boat(0, 1, Direction.South);
					Boat boatNorthView = window.createBoat(Position.NORTH);
					model.vehicle.Boat boatSouth = new model.vehicle.Boat(0, 1, Direction.North);
					Boat boatSouthView = window.createBoat(Position.SOUTH);
					boatNorth.forward();
					MoveBoatController moveBoatNorth = new MoveBoatController(boatNorth, boatNorthView);
					Thread threadBoatNorth = new Thread(moveBoatNorth);
					threadBoatNorth.start();
					boatSouth.forward();
					MoveBoatController moveBoatSouth = new MoveBoatController(boatSouth, boatSouthView);	
					Thread threadBoatSouth = new Thread(moveBoatSouth);
					threadBoatSouth.start();										
				}
				else
				{
					synchronized (Thread.currentThread())
					{
						Thread.currentThread().wait();
					}
				}
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
					Thread.currentThread().wait(5000);
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
