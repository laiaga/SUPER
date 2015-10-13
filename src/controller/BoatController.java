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
				Bridge bridge = Bridge.getInstance();
				BicolorLight lightNorth = bridge.getLightNorth();
				BicolorLight lightSouth = bridge.getLightSouth();
				model.vehicle.Boat boatNorth = new model.vehicle.Boat(0, 1, Direction.South);
				Boat boatNorthView = window.createBoat(Position.NORTH);
				model.vehicle.Boat boatSouth = new model.vehicle.Boat(0, 1, Direction.North);
				Boat boatSouthView = window.createBoat(Position.SOUTH);
				if(bridge.getState() == PositionBridge.Up)
				{
					if(lightNorth.getFeux() == ColorLights.VERT)
					{
						boatNorth.forward();
						MoveBoatController moveBoatNorth = new MoveBoatController(boatNorth, boatNorthView);
					}
					if(lightSouth.getFeux() == ColorLights.VERT)
					{
						boatSouth.forward();
						MoveBoatController moveBoatSouth = new MoveBoatController(boatSouth, boatSouthView);						
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
