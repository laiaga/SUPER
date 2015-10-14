package controller;

import view.View;
import model.BicolorLight;
import model.Bridge;
import model.ColorLights;
import model.PositionBridge;
import model.TricolorLight;

/**
 * @author Ghislain Dugat, Abdelkader Benameur, Guélaud Lepetit
 *
 */
public class BridgeController implements Runnable
{
	private View window;
	private Thread threadCarsController;
	private Thread threadBoatsController;
	
	private view.Bridge bridgeView;
	private view.TrafficBi lightNorthView;
	private view.TrafficBi lightSouthView;
	private view.TrafficTri lightEastView;
	private view.TrafficTri lightWestView;
	private view.Barrier barrierEastView;
	private view.Barrier barrierWestView;
    
	private Bridge bridge;
	private BicolorLight lightNorth;
	private BicolorLight lightSouth;
	private TricolorLight lightEast;
	private TricolorLight lightWest;
	private model.Barrier barrierEast;
	private model.Barrier barrierWest;
	
	public int carTime;
	public int boatTime;
	
	/**
	 * @param window
	 * @param threadCarsController
	 * @param threadBoatsController
	 */
	public BridgeController(View window, Thread threadCarsController, Thread threadBoatsController)
	{
		this.window = window;
		this.threadCarsController = threadCarsController;
		this.threadBoatsController = threadBoatsController;
		
		this.bridgeView = window.getBridge();
		this.lightNorthView = window.getTraffic_bi_north();
		this.lightSouthView = window.getTraffic_bi_south();
		this.lightEastView = window.getTraffic_tri_east();
		this.lightWestView = window.getTraffic_tri_west();
		this.barrierEastView = window.getBarrier_east();
		this.barrierWestView = window.getBarrier_west();
	    
		this.bridge = Bridge.getInstance();
		this.lightNorth = bridge.getLightNorth();
		this.lightSouth = bridge.getLightSouth();
		this.lightEast = bridge.getLightEast();
		this.lightWest = bridge.getLightWest();
		this.barrierEast = bridge.getBarrierEast();
		this.barrierWest = bridge.getBarrierWest();
		
		this.carTime = 10000;
		this.boatTime = 20000;
	}
	
	public void run()
	{
		while(true)
	    {	    	
	    	synchronized (Thread.currentThread())
			{
				try
				{
					Thread.currentThread().wait(carTime);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    	
	    	System.out.println("La circulation passe aux bateaux.");
    		lightEast.setFeux(ColorLights.ORANGE);
    		lightEastView.setOrange();
    		lightWest.setFeux(ColorLights.ORANGE);
    		lightWestView.setOrange();
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
    		lightEast.setFeux(ColorLights.ROUGE);
    		lightEastView.setRed();
    		lightWest.setFeux(ColorLights.ROUGE);
    		lightWestView.setRed();
	    	while(bridge.areThereCars())
	    	{
	    		synchronized (Thread.currentThread())
				{
					try
					{
						Thread.currentThread().wait(500);
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	    	}
	    	if(!bridge.areThereCars())
	    	{
	    		barrierEast.down();
	    		barrierEastView.close();
	    		barrierWest.down();
	    		barrierWestView.close();
	    		
	    		openBridge();
	    		bridgeView.open();
	    		
	    		lightNorth.setFeux(ColorLights.VERT);
	    		lightNorthView.setGreen();
	    		lightSouth.setFeux(ColorLights.VERT);
	    		lightSouthView.setGreen();
	    		
	    		synchronized (threadBoatsController)
				{
	    			try
		    		{
		    			threadBoatsController.notify();
		    		}
		    		catch(IllegalMonitorStateException e)
		    		{
						// TODO Auto-generated catch block
						e.printStackTrace();	    			
		    		}
				}
	    	}
	    	
	    	synchronized (Thread.currentThread())
			{
				try
				{
					Thread.currentThread().wait(boatTime);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    	
	    	System.out.println("La circulation passe aux voitures.");
	    	lightNorth.setFeux(ColorLights.ROUGE);
    		lightNorthView.setRed();
    		lightSouth.setFeux(ColorLights.ROUGE);
    		lightSouthView.setRed();
	    	while(bridge.areThereBoats())
	    	{
	    		synchronized (Thread.currentThread())
				{
					try
					{
						Thread.currentThread().wait(500);
					}
					catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	    	}
	    	if(!bridge.areThereBoats())
	    	{
	    		closeBridge();
	    		bridgeView.close();
	    		
	    		lightEast.setFeux(ColorLights.VERT);
	    		lightEastView.setGreen();
	    		lightWest.setFeux(ColorLights.VERT);
	    		lightWestView.setGreen();
	    		
	    		barrierEast.up();
	    		barrierEastView.open();
	    		barrierWest.up();
	    		barrierWestView.open();
	    		synchronized (threadCarsController)
				{
	    			try
		    		{
		    			threadCarsController.notify();
		    		}
		    		catch(IllegalMonitorStateException e)
		    		{
						// TODO Auto-generated catch block
						e.printStackTrace();	    			
		    		}
				}
	    	}
	    }
	}
	
	private void closeBridge()
	{
		if(bridge.getState() != PositionBridge.Down)
		{
			bridge.setState(PositionBridge.Moving);
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
			bridge.setState(PositionBridge.Down);
		}
	}
	
	private void openBridge()
	{
		if(bridge.getState() != PositionBridge.Up)
		{
			bridge.setState(PositionBridge.Moving);
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
			bridge.setState(PositionBridge.Up);
		}
	}
}
