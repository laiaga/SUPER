package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ButtonsController;

@SuppressWarnings("serial")
public class ButtonsColumn extends JFrame {
	private boolean maintenance;
	private JPanel buttonsPanel;
	private ButtonsController controller;

	public ButtonsColumn(ButtonsController controller){
		maintenance = false;
		this.controller = controller;
		
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
	
	public ButtonsColumn(ButtonsController controller, boolean maintenance){
		this.maintenance = maintenance;
		this.controller = controller;
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(9,1));
		
		
		if(maintenance){
			maintenanceMode();
		}
		else{
			normalMode();
		}
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setContentPane(buttonsPanel);
		getContentPane().setBackground(Color.WHITE);
		setBounds(1327,100,200,858);
	}
	
	public void normalMode(){
		JButton maintenance = new JButton("Mode maintenance");
		maintenance.setName("maintenance");
		maintenance.addActionListener(controller);
		buttonsPanel.add(maintenance);
	}
	
	
	public void maintenanceMode(){
		JButton bridgeUp = new JButton("Lever tabliers");
		bridgeUp.setName("bridgeUp");
		bridgeUp.addActionListener(controller);
		
		JButton bridgeDown = new JButton("Abaisser tabliers");
		bridgeDown.setName("bridgeDown");
		bridgeDown.addActionListener(controller);
		
		JButton barrierUp = new JButton("Lever barrières");
		barrierUp.setName("barrierUp");
		barrierUp.addActionListener(controller);
		
		JButton barrierDown = new JButton("Abaisser barrières");
		barrierDown.setName("barrierDown");
		barrierDown.addActionListener(controller);
		
		JButton lightsRed = new JButton("Tous feux au rouge");
		lightsRed.setName("lightsRed");
		lightsRed.addActionListener(controller);
		
		JButton lightsGreen = new JButton("Tous feux au vert");
		lightsGreen.setName("lightsGreen");
		lightsGreen.addActionListener(controller);
		
		buttonsPanel.add(bridgeUp);
		buttonsPanel.add(bridgeDown);
		buttonsPanel.add(barrierUp);
		buttonsPanel.add(barrierDown);
		buttonsPanel.add(lightsRed);
		buttonsPanel.add(lightsGreen);
		buttonsPanel.repaint();
		this.revalidate();
	}
	
	public void setMaintenance(boolean maintenance){
		this.maintenance = maintenance;
	}
	
}
