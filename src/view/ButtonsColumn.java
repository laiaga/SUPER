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
		JButton maintenance = new JButton("Mode maintenance");
		maintenance.addActionListener(null);
		buttonsPanel.add(maintenance);
	}
	
	
	private void maintenanceMode(){
		
		JButton bridgeUp = new JButton("Lever tabliers");
		bridgeUp.addActionListener(null);
		JButton bridgeDown = new JButton("Abaisser tabliers");
		bridgeDown.addActionListener(null);
		JButton barrierUp = new JButton("Lever barrières");
		barrierUp.addActionListener(null);
		JButton barrierDown = new JButton("Abaisser barrières");
		barrierDown.addActionListener(null);
		JButton lightsRed = new JButton("Tous feux au rouge");
		lightsRed.addActionListener(null);
		JButton lightsGreen = new JButton("Tous feux au vert");
		lightsGreen.addActionListener(null);
		
		buttonsPanel.add(bridgeUp);
		buttonsPanel.add(bridgeDown);
		buttonsPanel.add(barrierUp);
		buttonsPanel.add(barrierDown);
		buttonsPanel.add(lightsRed);
		buttonsPanel.add(lightsGreen);
	}
	
	public void setMaintenance(boolean maintenance){
		this.maintenance = maintenance;
	}
	
}
