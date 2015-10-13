package view;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * Modelization of a boat of a random color
 * @author Loic Vierin
 */
@SuppressWarnings("serial")
public class Car extends JPanel {
	
	private BufferedImage bufferedImgCar;
	private JImage imgCar;
	private JLayeredPane layeredPane;
	private Position pos;
	private Point p;
	
		
	public Car(JLayeredPane layeredPane, Position pos) throws IOException {
		super();
		
		int max=6;
		int min=1;
		int rand= (int) ( Math.random()*( max - min + 1 ) ) + min;
		String img = ImagePath.CAR.toString() + rand + ".png";
		BufferedImage originBufferedImgCar = ImageIO.read(new File(img));
		
		this.layeredPane = layeredPane;
		
		this.setOpaque(false);
		
		this.p = new Point();
		this.pos = pos;
		int rot=0;
		if(pos == Position.EAST) {
			p.x=140;
			p.y=345;
			rot=90;
		}
		else if (pos == Position.WEST) {
			p.x=620;
			p.y=405;
			rot=-90;
		}
		else {
			p.x=0;
			p.y=0;
		}
		
	    
	    AffineTransform xform = new AffineTransform();
	    xform.translate(0.5*originBufferedImgCar.getHeight(), 0.5*originBufferedImgCar.getWidth());
	    xform.rotate(Math.toRadians(rot));
	    xform.translate(-0.5*originBufferedImgCar.getWidth(), -0.5*originBufferedImgCar.getHeight());
	    
	    AffineTransformOp op = new AffineTransformOp(xform, AffineTransformOp.TYPE_BILINEAR);
	    bufferedImgCar = op.filter(originBufferedImgCar, null);
	    
		imgCar = new JImage(new ImageIcon(bufferedImgCar));
		
		this.layeredPane.setLayer(this, 1);

		this.setBounds(p.x,p.y, bufferedImgCar.getWidth(), bufferedImgCar.getHeight()+10);
		this.add(imgCar);
		this.layeredPane.add(this);
	}
	
	/**
	 * Modifies the car position along a line according to its starting point
	 * (Add x at it's x position)
	 * @param x 
	 */
	public void move(int x) {
		if(pos == Position.EAST)
			p.x += x;
		else
			p.x -=x;
		this.setBounds(p.x,p.y, bufferedImgCar.getWidth(), bufferedImgCar.getHeight()+10);
		
		if(p.x==0 || p.x==800)
			hide();
	}
	
	/**
	 * Sets the the value of the p attribute and modifies the bounds of the panel accordingly
	 * @param p the new position (as a couple (x,y)) of the panel
	 */
	public void put(Point p) {
		this.p = p;
		this.setBounds(p.x,p.y, bufferedImgCar.getWidth(), bufferedImgCar.getHeight()+10);
		
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
