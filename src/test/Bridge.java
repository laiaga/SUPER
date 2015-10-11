package test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class Bridge extends JPanel { 
  public void paintComponent(Graphics g){                                  
   	Graphics2D g2 = (Graphics2D) g;
	
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    g.setColor(Color.BLACK);
    
   	//line thickness
    g2.setStroke(new BasicStroke(2));

    //left vertical line
	g2.drawLine(getWidth()/4,0, getWidth()/4, (8*getHeight()/10)/2);
	g2.drawLine(getWidth()/4,(12*getHeight()/10)/2, getWidth()/4, getHeight());
	 
	//right vertical line
	g2.drawLine(3*getWidth()/4,0, 3*getWidth()/4, (8*getHeight()/10)/2);
	g2.drawLine(3*getWidth()/4,(12*getHeight()/10)/2, 3*getWidth()/4, getHeight());
	
	//line thickness
	g2.setStroke(new BasicStroke(4));
	
	//upper horizontal line
	g2.drawLine(0,(8*getHeight()/10)/2,3*getWidth()/10,(8*getHeight()/10)/2);
	g2.drawLine(7*getWidth()/10,(8*getHeight()/10)/2,getWidth(),(8*getHeight()/10)/2);
	
	//lower horizontal line
	g2.drawLine(0,(12*getHeight()/10)/2,3*getWidth()/10,(12*getHeight()/10)/2);
	g2.drawLine(7*getWidth()/10,(12*getHeight()/10)/2,getWidth(),(12*getHeight()/10)/2);
  }    
  
  public void addCar(){
	  
  }
}