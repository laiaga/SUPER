package view;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Modelisation of a road barrier used to stop the car flow
 * @author Loic Vierin
 */
@SuppressWarnings("serial")
public class Barrier extends JPanel{
	private BufferedImage bufferedImgBarrier;
	private JImage imgBarrier;
	private Point p;
	
	public Barrier(JLayeredPane layeredPane, Position pos) throws IOException {
		super();
		
		this.setOpaque(false);
		
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
	
	
	/*public void close() {
		this.pos2 = PositionBridge.Moving;
		try {
			int w = 0;
			for(int i=0; i<400; i++) {
				move(-1);
				
				Thread.sleep(15);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pos2=PositionBridge.Down;
		
			
	}
	
	public void open() { 
		this.pos2 = PositionBridge.Moving;
		try {
			int w = 0;
			for(int i=0; i<400; i++) {
				move(1);
				
				Thread.sleep(15); 
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pos2=PositionBridge.Open;
		
			
	}
	
	
	public void move(int y) {
		p.y +=y;
		panelBarrier.setBounds(p.x,p.y, picture_barrier.getWidth(), picture_barrier.getHeight()+10);
	}*/
	
	/**
	 * Sets the the value of the p attribute  and modifies the bounds of the panel accordingly
	 * @param p the new position (as a couple (x,y)) of the panel
	 */
	public void put(Point p) {
		this.p = p;
		setBounds(p.x,p.y, bufferedImgBarrier.getWidth(), bufferedImgBarrier.getHeight()+10);
		
	}
	
	/**
	 * Hides the panel by allocating him a 0x0 area on screen 
	 */
	public void hide() {
		setBounds(p.x,p.y,0, 0);
		
	}
}
