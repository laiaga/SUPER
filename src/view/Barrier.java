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
	private BridgeState position; //barrier up or down
	private Position place; //barrier east/west
	
	public Barrier(JLayeredPane layeredPane, Position pos) throws IOException {
		super();
		this.position = BridgeState.DOWN;
		
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
	
	/**
	 * Close the barrier with an animation
	 */
	public void close() { 
		if(this.position == BridgeState.UP) {
			this.position = BridgeState.MOVING;
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

			this.position=BridgeState.DOWN;
			System.out.println("Barrier "+ place + " : " + position);
		}
		
		else
			System.err.println("Error: Barrier already closed !");
		
			
	}
	
	/**
	 * Open the barrier with an animation
	 */
	public void open() { 
		if(this.position == BridgeState.DOWN) {
			this.position = BridgeState.MOVING;
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
			this.position=BridgeState.UP;
			System.out.println("Barrier "+ place + " : " + position);
		} 
		else
			System.err.println("Error: Barrier already up !");
		
			
	}
	

	public void setOpen() {
		if(this.position == BridgeState.DOWN) {
			if(place == Position.EAST)
				p.y+=200;
			else
				p.y-=200;
			this.setBounds(p.x, p.y, bufferedImgBarrier.getWidth(), bufferedImgBarrier.getHeight()+10);
	
			this.position = BridgeState.UP;
			System.out.println("Barrier "+ place + " : " + position);
		} 
		else
			System.err.println("Error: Barrier already up !");
	}
	
	public void setClose() {
		if(this.position == BridgeState.UP) {
			if(place == Position.EAST)
				p.y-=200;
			else
				p.y+=200;
			this.setBounds(p.x, p.y, bufferedImgBarrier.getWidth(), bufferedImgBarrier.getHeight()+10);
	
			this.position = BridgeState.DOWN;
			System.out.println("Barrier "+ place + " : " + position);
		}
		else
			System.err.println("Error: Barrier already Down !");
		
	}
	
	/**
	 * Move the barrier on the y axe.
	 * @param y
	 */
	public void move(int y) {
		p.y +=y;
		this.setBounds(p.x,p.y, bufferedImgBarrier.getWidth(), bufferedImgBarrier.getHeight()+10);
	}
	

	/**
	 * Sets the barrier at the Point p
	 * @param p the new position (as a couple (x,y))
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
	
	
	public Point getP() {
		return p;
	}

	public BridgeState getPosition() {
		return position;
	}

	public Position getPlace() {
		return place;
	}
}
