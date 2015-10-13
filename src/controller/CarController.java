package controller;

import java.io.IOException;

import model.Bridge;
import model.PositionBridge;
import model.vehicle.*;
import view.Car;
import view.Position;
import view.View;

public class CarController implements Runnable
{
	
	private View window;

	public CarController(View window)
	{
		this.window = window;
	}

	@Override
	public void run() {
		while(true)
		{
			try {
				model.vehicle.Car carEast = new model.vehicle.Car(0, 1, Direction.West);
				Car carEastView = window.createCar(Position.EAST);
				model.vehicle.Car carWest = new model.vehicle.Car(0, 1, Direction.East);
				Car carWestView = window.createCar(Position.WEST);
				if(Bridge.getInstance().getState() == PositionBridge.Down)
				{
					carEast.forward();
					carWest.forward();
					MoveCarController moveCarEast = new MoveCarController(carEast, carEastView);
					MoveCarController moveCarWest = new MoveCarController(carWest, carEastView);
					
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
