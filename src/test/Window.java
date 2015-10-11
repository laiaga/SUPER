package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
 
@SuppressWarnings("serial")
public class Window extends JFrame {
	
  public Window(){                
    this.setTitle("Simulation de pont mobile");
    this.setSize(1024, 768);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //this.setContentPane(background);
	Bridge bridge = new Bridge();
	bridge.setBackground(Color.DARK_GRAY);
	bridge.setPreferredSize(new Dimension(800,600));
	
	InfosColumn infos = new InfosColumn();
	infos.setBackground(Color.RED);
	
	ButtonsColumn buttons = new ButtonsColumn();
	buttons.setBackground(Color.BLUE);
	

	JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,bridge,infos);
	//pane.setResizeWeight(0.75);
	//pane.setDividerLocation(0.75);
	
	this.getContentPane().add(pane,BorderLayout.CENTER);
	this.getContentPane().add(buttons, BorderLayout.EAST);
	
    
    this.setVisible(true); 
  } 
  
  /*public void addCar(){
	  background.addCar();
  }*/
}