package controller;
import java.io.IOException;

import view.View;

/**
 * @author Ghislain Dugat, Abdelkader Benameur, Guélaud Lepetit
 *
 */
public class SystemContoller
{
	
	private static View window;

	
	public SystemContoller()
	{
		
	}
		
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		window = new View();
		
		CarController carsController = new CarController(window);
		Thread threadCarsController = new Thread(carsController);
	    threadCarsController.start();
	    BoatController boatsController = new BoatController(window);
	    Thread threadBoatsController = new Thread(boatsController);
	    threadBoatsController.start();
	    
	    BridgeController bridgeController = new BridgeController(window, threadCarsController, threadBoatsController);
	    Thread threadBridgeController = new Thread(bridgeController);
	    threadBridgeController.start();
	}
}


