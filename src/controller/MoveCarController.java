package controller;

import java.awt.Point;

import model.vehicle.Car;
import model.vehicle.Direction;

public class MoveCarController implements Runnable
{
	private Car car;
	private view.Car carView;
	
	public MoveCarController(Car car, view.Car carView)
	{
		this.car = car;
		this.carView = carView;
		
	}

	@Override
	public void run()
	{
		while(car != null)
		{
			int x = 0;
			if(car.getDirection() == Direction.West)
			{
				x = car.getPosition() + 140;
			}
			else
			{
				
			}
		}
		
	}

}
