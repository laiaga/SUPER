package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
 
@SuppressWarnings("serial")
public class Window extends JFrame {
	private Bridge bridge;
	private ButtonsColumn buttons;
	private InfosColumn infos;
	
	public Bridge getBridge() {
		return bridge;
	}
	public void setBridge(Bridge bridge) {
		this.bridge = bridge;
	}
	public ButtonsColumn getButtons() {
		return buttons;
	}
	public void setButtons(ButtonsColumn buttons) {
		this.buttons = buttons;
	}
	public InfosColumn getInfos() {
		return infos;
	}
	public void setInfos(InfosColumn infos) {
		this.infos = infos;
	}


public Window(){                
    this.setTitle("Simulation de pont mobile");
    this.setSize(1024, 768);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //this.setContentPane(background);
	bridge = new Bridge();
	bridge.setBackground(Color.DARK_GRAY);
	bridge.setPreferredSize(new Dimension(800,600));
	
	infos = new InfosColumn();
	infos.setBackground(Color.LIGHT_GRAY);
	
	buttons = new ButtonsColumn();
	buttons.setBackground(Color.LIGHT_GRAY);
	

	JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,bridge,infos);
	//pane.setResizeWeight(0.75);
	//pane.setDividerLocation(0.75);
	
	this.getContentPane().add(pane,BorderLayout.CENTER);
	this.getContentPane().add(buttons, BorderLayout.EAST);
	
    
    this.setVisible(true); 
  } 
  
  public void maintenanceMode(){
	  ButtonsColumn b = new ButtonsColumn(true);
	  b.setBackground(Color.LIGHT_GRAY);
		
	  getContentPane().remove(buttons);
	  getContentPane().add(b, BorderLayout.EAST);
  }
}