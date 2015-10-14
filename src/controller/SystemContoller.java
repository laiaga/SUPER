package controller;
import java.io.IOException;

import view.View;

/**
 * Use threads to control environnement
 * @author Ghislain Dugat, Abdelkader Benameur, Guelaud Lepetit
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
		
	    StateLabelController stateLabelController = new StateLabelController(window);
	    Thread threadStateLabelController = new Thread(stateLabelController);
	    threadStateLabelController.start();

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


