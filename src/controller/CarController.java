package controller;

import java.io.IOException;

import model.Bridge;
import model.ColorLights;
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
	public void run()
	{
		while(true)
		{
			try
			{
				if(Bridge.getInstance().getState() == PositionBridge.Down
						&& Bridge.getInstance().getLightEast().getFeux() == ColorLights.VERT && Bridge.getInstance().getLightWest().getFeux() == ColorLights.VERT)
				{
					model.vehicle.Car carEast = new model.vehicle.Car(0, 100, Direction.West);
					Car carEastView = window.createCar(Position.EAST);
					model.vehicle.Car carWest = new model.vehicle.Car(0, 100, Direction.East);
					Car carWestView = window.createCar(Position.WEST);
					MoveCarController moveCarEast = new MoveCarController(carEast, carEastView);
					MoveCarController moveCarWest = new MoveCarController(carWest, carWestView);
					Thread threadCarEast = new Thread(moveCarEast);
				    Thread threadCarWest = new Thread(moveCarWest);
				    threadCarEast.start();
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
				    threadCarWest.start();
					
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
