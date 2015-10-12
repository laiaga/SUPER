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

public class SystemContoller implements Runnable {

	public void run() {
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {

		View window = new View();
		int speed = 1;
		Car car1 = window.createCar(Position.EAST);
		Car car2 = null;
		Car car3 = null;
		Car car4 = null;
		Boat boat1 = window.createBoat(Position.NORTH);
		Boat boat2 = null;
		Boat boat3 = null;
		Boat boat4 = null;
		view.Bridge bridge = window.createBridge(BridgeState.DOWN);
		Barrier barrier= window.createBarrier(Position.EAST);
		Barrier barrier2= window.createBarrier(Position.WEST);
		
		TrafficTri traffic1 = window.createTrafficTri(Position.EAST);
		TrafficTri traffic2 = window.createTrafficTri(Position.WEST);
		TrafficBi traffic3 = window.createTrafficBi(Position.NORTH);
		TrafficBi traffic4 = window.createTrafficBi(Position.SOUTH);
			
		barrier.setOpen(); 
		barrier2.setOpen();
			
		traffic1.setOrange();
		traffic2.setOrange();
		Thread.sleep(1000);
		traffic1.setRed();
		traffic2.setRed();
		traffic3.setGreen();
		traffic4.setGreen();
		
		barrier.close();
		barrier2.close();
		
		bridge.open();
		
		for(int i=0; i<=700; i++ ) {
			boat1.move(1);
			if(boat2!=null)
				boat2.move(1); 
			if(boat3!=null)
				boat3.move(2); //vitesse modifiable
			if(boat4!=null)
				boat4.move(1);
			Thread.sleep(speed);
			if(i==125)
				boat3 = window.createBoat(Position.SOUTH);
			
			if(i==200)
			{
				boat2 = window.createBoat(Position.NORTH);
				boat4 = window.createBoat(Position.SOUTH);
			}
		}
		
		boat1.hide();
		boat2.hide();
		boat3.hide();
		boat4.hide();
		
		traffic1.setRed();
		traffic2.setRed();
		traffic3.setRed();
		traffic4.setRed();
		
		bridge.close();
		barrier.open();
		barrier2.open();
		

		traffic1.setGreen();
		traffic2.setGreen();
		traffic3.setRed();
		traffic4.setRed();
		
		
		((JProgressBar) window.getContentPane().getComponent(2)).setValue(0);
		((JProgressBar) window.getContentPane().getComponent(2)).setMaximum(700);
		for(int i=0; i<=700; i++ ) {
			((JProgressBar) window.getContentPane().getComponent(2)).setValue(i);
			car1.move(1);
			if(car2!=null)
				car2.move(1); 
			if(car3!=null)
				car3.move(2); //vitesse modifiable
			if(car4!=null)
				car4.move(1);
			Thread.sleep(speed);
			if(i==125)
				car3 = window.createCar(Position.WEST);
			
			if(i==200)
			{
				car2 = window.createCar(Position.EAST);
				car4 = window.createCar(Position.WEST);
			}
		
	}
 
		car1.hide();
		car2.hide();
		car3.hide();
		car4.hide();
		
	}


}


