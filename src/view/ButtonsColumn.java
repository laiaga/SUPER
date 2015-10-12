package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonsColumn extends JPanel {
	private boolean maintenance;

	public ButtonsColumn(){
		maintenance = false;
		
		this.setLayout(new GridLayout(10,1));
		
		normalMode();
		System.out.println("test");
		if(maintenance){
			maintenanceMode();
		}
	}
	
	public ButtonsColumn(boolean maintenance){
		this.maintenance = maintenance;
		
		this.setLayout(new GridLayout(9,1));
		
		normalMode();
		
		if(maintenance){
			maintenanceMode();
		}
	}
	
	private void normalMode(){
		JButton sendCar = new JButton("Envoyer voiture");
		JButton sendBoat = new JButton("Envoyer bateau");
		JButton maintenance = new JButton("Mode maintenance");
		
		this.add(sendCar);
		this.add(sendBoat);
		this.add(maintenance);
	}
	
	
	private void maintenanceMode(){
		
		JButton bridgeUp = new JButton("Lever tabliers");
		JButton bridgeDown = new JButton("Abaisser tabliers");
		JButton fenceUp = new JButton("Lever barrières");
		JButton fenceDown = new JButton("Abaisser barrières");
		JButton lightsRed = new JButton("Tous feux au rouge");
		JButton lightsGreen = new JButton("Tous feux au vert");
		
		this.add(bridgeUp);
		this.add(bridgeDown);
		this.add(fenceUp);
		this.add(fenceDown);
		this.add(lightsRed);
		this.add(lightsGreen);
	}
	
	public void setMaintenance(boolean maintenance){
		this.maintenance = maintenance;
	}
	
}
