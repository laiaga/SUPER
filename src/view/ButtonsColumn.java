package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonsColumn extends JFrame {
	private boolean maintenance;
	private JPanel buttonsPanel;

	public ButtonsColumn(){
		maintenance = false;
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(9,1));
		
		normalMode();
		if(maintenance){
			maintenanceMode();
		}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setContentPane(buttonsPanel);
		getContentPane().setBackground(Color.WHITE);
		setBounds(1327,100,200,858);
	}
	
	public ButtonsColumn(boolean maintenance){
		this.maintenance = maintenance;
		
		buttonsPanel.setLayout(new GridLayout(9,1));
		
		normalMode();
		
		if(maintenance){
			maintenanceMode();
		}
	}
	
	private void normalMode(){
		JButton sendCar = new JButton("Envoyer voiture");
		JButton sendBoat = new JButton("Envoyer bateau");
		JButton maintenance = new JButton("Mode maintenance");
		
		buttonsPanel.add(sendCar);
		buttonsPanel.add(sendBoat);
		buttonsPanel.add(maintenance);
	}
	
	
	private void maintenanceMode(){
		
		JButton bridgeUp = new JButton("Lever tabliers");
		JButton bridgeDown = new JButton("Abaisser tabliers");
		JButton fenceUp = new JButton("Lever barrières");
		JButton fenceDown = new JButton("Abaisser barrières");
		JButton lightsRed = new JButton("Tous feux au rouge");
		JButton lightsGreen = new JButton("Tous feux au vert");
		
		buttonsPanel.add(bridgeUp);
		buttonsPanel.add(bridgeDown);
		buttonsPanel.add(fenceUp);
		buttonsPanel.add(fenceDown);
		buttonsPanel.add(lightsRed);
		buttonsPanel.add(lightsGreen);
	}
	
	public void setMaintenance(boolean maintenance){
		this.maintenance = maintenance;
	}
	
}
