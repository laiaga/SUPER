package controller;
import java.io.IOException;

import view.View;

public class SystemContoller
{
	
	private static View window;

	
	public SystemContoller()
	{
		
	}
		
	public static void main(String[] args) throws IOException
	{
		window = new View();
		
		ButtonsController buttonsController = new ButtonsController(window);
		Thread threadButtonsController = new Thread(buttonsController);
		threadButtonsController.start();
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


