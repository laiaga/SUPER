package controller;

import view.View;
import model.BicolorLight;
import model.Bridge;
import model.ColorLights;
import model.TricolorLight;

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
	
	public int switchTime;
	
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
		
		this.switchTime = 15000;
	}
	
	public void run()
	{
		while(true)
	    {	    	
	    	synchronized (Thread.currentThread())
			{
				try
				{
					Thread.currentThread().wait(switchTime);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    	
	    	System.out.println("La circulation passe aux bateaux.");
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
	    		
	    		bridge.up();
	    		bridgeView.open();
	    		
	    		lightNorth.setFeux(ColorLights.VERT);
	    		lightNorthView.setRed();
	    		lightSouth.setFeux(ColorLights.VERT);
	    		lightSouthView.setRed();
	    		
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
	    	
	    	synchronized (Thread.currentThread())
			{
				try
				{
					Thread.currentThread().wait(switchTime);
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
	    		bridge.down();
	    		bridgeView.close();
	    		
	    		lightEast.setFeux(ColorLights.VERT);
	    		lightEastView.setGreen();
	    		lightWest.setFeux(ColorLights.VERT);
	    		lightWestView.setGreen();
	    		
	    		barrierEast.up();
	    		barrierEastView.open();
	    		barrierWest.up();
	    		barrierWestView.open();
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
