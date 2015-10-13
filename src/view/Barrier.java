package view;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.PositionBridge;

/**
 * Modelisation of a road barrier used to stop the car flow
 * @author Loic Vierin
 */
@SuppressWarnings("serial")
public class Barrier extends JPanel{
	private BufferedImage bufferedImgBarrier;
	private JImage imgBarrier;
	private Point p;
	private PositionBridge position; //barrier up or down
	private Position place; //barrier east/west
	
	public Barrier(JLayeredPane layeredPane, Position pos) throws IOException {
		super();
		this.position = PositionBridge.Down;
		
		this.setOpaque(false);
		
		this.place = pos;
		
		this.p = new Point();
		if(pos == Position.EAST) {
			p.x=375;
			p.y=325;
		}
		else if (pos == Position.WEST) {
			p.x=-15;
			p.y=200;
		}
		else {
			p.x=0;
			p.y=0;
		}
		
		bufferedImgBarrier = ImageIO.read(new File(ImagePath.BARRIER.toString()));
		imgBarrier = new JImage(new ImageIcon(bufferedImgBarrier));
		this.setBounds(p.x,p.y, bufferedImgBarrier.getWidth(), bufferedImgBarrier.getHeight()+10);
		
		layeredPane.setLayer(this, 1);

		this.add(imgBarrier);
		layeredPane.add(this);	
	}
	
	
	public void close() { 
		if(this.position == PositionBridge.Up) {
			this.position = PositionBridge.Moving;
			try {
				int width = 0;
				for(int i=0; i<200; i++) {
					
					if(place == Position.EAST)
					move(-1);
					else
						move(1);
					
					Thread.sleep(View.speed); 
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.position=PositionBridge.Down;
		}
		
		else
			System.err.println("Error: Barrier already closed !");
		
			
	}
	
	public void open() { 
		if(this.position == PositionBridge.Down) {
			this.position = PositionBridge.Moving;
			try {
				int width = 0;
				for(int i=0; i<200; i++) {
					if(place == Position.EAST)
					move(1);
					else
						move(-1);
					
					Thread.sleep(View.speed); 
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.position=PositionBridge.Up;
		} 
		else
			System.err.println("Error: Barrier already up !");
		
			
	}
	
	public void setOpen() {
		if(this.position == PositionBridge.Down) {
			if(place == Position.EAST)
				p.y+=200;
			else
				p.y-=200;
			this.setBounds(p.x, p.y, bufferedImgBarrier.getWidth(), bufferedImgBarrier.getHeight()+10);
	
			this.position = PositionBridge.Up;
		} 
		else
			System.err.println("Error: Barrier already up !");
	}
	
	public void setClose() {
		if(this.position == PositionBridge.Up) {
			if(place == Position.EAST)
				p.y-=200;
			else
				p.y+=200;
			this.setBounds(p.x, p.y, bufferedImgBarrier.getWidth(), bufferedImgBarrier.getHeight()+10);
	
			this.position = PositionBridge.Up;
		}
		else
			System.err.println("Error: Barrier already Down !");
		
	}
	
	
	public void move(int y) {
		p.y +=y;
		this.setBounds(p.x,p.y, bufferedImgBarrier.getWidth(), bufferedImgBarrier.getHeight()+10);
	}
	
	/**
	 * Sets the the value of the p attribute  and modifies the bounds of the panel accordingly
	 * @param p the new position (as a couple (x,y)) of the panel
	 */
	public void put(Point p) {
		this.p = p;
		this.setBounds(p.x,p.y, bufferedImgBarrier.getWidth(), bufferedImgBarrier.getHeight()+10);
		
	}
	
	/**
	 * Hides the panel by allocating him a 0x0 area on screen 
	 */
	public void hide() {
		this.setBounds(p.x,p.y,0, 0);
		
	}
}
