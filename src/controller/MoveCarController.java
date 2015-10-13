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
		while(car.getPosition() < 761)
		{
			int x = 0;
			if(car.getDirection() == Direction.West)
			{
				x = car.getPosition() + 140 - carView.getP().x;
			}
			else
			{
				x = 620 - car.getPosition() + carView.getP().x;
			}
			carView.move(x);
			try {
				Thread.currentThread().wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		carView.hide();
		
	}

}
