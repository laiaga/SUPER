package controller;
import java.io.IOException;
import javax.swing.JProgressBar;
import view.Barrier;
import view.Boat;
import view.BridgeState;
import view.Car;
import view.Position;
import view.TrafficBi;
import view.TrafficTri;
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
		CarController carController = new CarController(window);
		Thread threadCarContoller = new Thread(carController);
	    threadCarContoller.start();
	    BoatController boatController = new BoatController(window);
	    Thread threadBoatController = new Thread(boatController);
	    threadBoatController.start();
	}
}


