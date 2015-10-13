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
 * Modelization of a boat with a random color
 * @author Loic Vierin
 */
@SuppressWarnings("serial")
public class Boat extends JPanel{
	
	private JImage imgBoat;
	private BufferedImage bufferedImgBoat;
	private JLayeredPane layeredPane;
	private Position pos;
	private Point p;
	
		
	public Boat(JLayeredPane layeredPane, Position pos) throws IOException {
		super();
		
		int max=5;
		int min=1;
		int rand= (int) ( Math.random()*( max - min + 1 ) ) + min;
		String img = ImagePath.BOAT.toString() + rand + ".png";
		bufferedImgBoat = ImageIO.read(new File(img));
		imgBoat = new JImage(new ImageIcon(bufferedImgBoat));
		
		this.layeredPane = layeredPane;
		this.setOpaque(false);
		p = new Point();
		this.pos = pos;
		if(pos == Position.SOUTH) {
			p.x=540;
			p.y=590;
		}
		else if (pos == Position.NORTH) {
			p.x=340;
			p.y=100;
		}
		else {
			p.x=0;
			p.y=0;
		}
		
		this.layeredPane.setLayer(this, 1);

		this.setBounds(p.x,p.y, bufferedImgBoat.getWidth(), bufferedImgBoat.getHeight()+10);

		this.add(imgBoat);
		layeredPane.add(this);
		System.out.println("New Boat "+ pos);
	}
	
	/**
	 * Modifies the boat position along a line according to its starting point
	 * @param y the modifier we apply to the axial coordinate of the boat
	 */
	public void move(int y) {
		if(pos == Position.SOUTH)
			p.y -= y;
		else
			p.y +=y;
		this.setBounds(p.x,p.y, bufferedImgBoat.getWidth(), bufferedImgBoat.getHeight()+10);
		
		if(p.y==0 || p.y==700)
			hide();
	}
	
	/**
	 * Sets the boat at the Point p
	 * @param p the new position (as a couple (x,y))
	 */
	public void put(Point p) {
		this.p = p;
		this.setBounds(p.x,p.y, bufferedImgBoat.getWidth(), bufferedImgBoat.getHeight()+10);	
	}
	
	/**
	 * Hides the panel by allocating him a 0x0 area on screen 
	 */
	public void hide() {
		this.setBounds(p.x,p.y,0, 0);
	}

	public Position getPos() {
		return pos;
	}

	public Point getP() {
		return p;
	}
}
