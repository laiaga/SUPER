package controller;


import model.vehicle.Boat;

/**
 * @author Ghislain Dugat, Abdelkader Benameur, Guélaud Lepetit
 *
 */
public class MoveBoatController implements Runnable
{
	
	private Boat boat;
	private view.Boat boatView;
	
	/**
	 * @param boat
	 * @param boatView
	 */
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
	
	/**
	 * @param boatView
	 * @param x
	 */
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
					Thread.currentThread().wait(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
