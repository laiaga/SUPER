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
		window.createBridge(BridgeState.DOWN);
		CarController carController = new CarController(window);
		carController.run();

	}
}


