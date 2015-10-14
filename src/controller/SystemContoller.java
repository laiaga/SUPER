package controller;
import java.io.IOException;

import javax.swing.JProgressBar;

import model.BicolorLight;
import model.Bridge;
import model.ColorLights;
import model.TricolorLight;
import view.Barrier;
import view.Boat;
import view.BridgeState;
import view.Car;
import view.Position;
import view.TrafficBi;
import view.TrafficTri;
import view.View;

/**
 * 
 * @author Sny_de_Treves
 * Use threads to control environnement
 *
 */
public class SystemContoller
{
	private static View window;

	
	public SystemContoller()
	{
		
	}
		
	public static void main(String[] args) throws IOException
	{
		window = new View();
	    
	    StateLabelController stateLabelController = new StateLabelController(window);
	    Thread threadStateLabelController = new Thread(stateLabelController);
	    threadStateLabelController.start();
		
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


