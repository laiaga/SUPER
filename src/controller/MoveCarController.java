package controller;

import java.awt.Point;

import model.vehicle.Car;
import model.vehicle.Direction;

/**
 * @author Ghislain Dugat, Abdelkader Benameur, Guélaud Lepetit
 *
 */
public class MoveCarController implements Runnable
{
	private Car car;
	private view.Car carView;
	
	/**
	 * @param car
	 * @param carView
	 */
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
			try
			{
				car.forward();
			} catch (Exception e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			moveCarView(carView, car.getSpeed());
		}
		carView.hide();
	}
	
	/**
	 * @param carView
	 * @param x
	 */
	private void moveCarView(view.Car carView, int x)
	{
		int delta = x / 20;
		while(x > delta)
		{
			carView.move(delta);
			x -= delta;
			synchronized (Thread.currentThread())
			{
				try
				{
					Thread.currentThread().wait(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
