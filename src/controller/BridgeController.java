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
	}
	
	public void run()
	{
		while(true)
	    {
    		lightNorth.setFeux(ColorLights.ROUGE);
    		lightNorthView.setRed();
    		lightSouth.setFeux(ColorLights.ROUGE);
    		lightSouthView.setRed();
	    	while(bridge.areThereBoats())
	    	{
	    		try
	    		{
	    			wait(500);
	    		}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	    		
	    		threadCarsController.notify();
	    	}
	    	
	    	try
    		{
    			wait(15000);
    		}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
    		lightEast.setFeux(ColorLights.ROUGE);
    		lightEastView.setRed();
    		lightWest.setFeux(ColorLights.ROUGE);
    		lightWestView.setRed();
	    	while(bridge.areThereCars())
	    	{
	    		try
	    		{
	    			wait(500);
	    		}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	    		
	    		threadBoatsController.notify();
	    	}
	    }
	}

}
