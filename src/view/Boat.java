/**
 * 
 */
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
 * @author Loic Vierin
 *
 */

//ceci est l'image sur l'interface de 1 voiture.
public class Boat {
	
	private ImageIcon icon_boat;
	private BufferedImage picture_boat;
	private JLayeredPane layeredPane;
	private JPanel panelBoat;
	private Position pos;
	private Point p;
	
		
	public Boat(JLayeredPane layeredPane, Position pos) throws IOException {
		
		this.picture_boat = ImageIO.read(new File("ressources/img/vehicles/boats/boat.png"));
		this.layeredPane = layeredPane;
		this.panelBoat = new JPanel();
		this.p = new Point();
		this.pos = pos;
		if(pos == Position.South) {
			p.x=300;
			p.y=350;
		}
		else if (pos == Position.North) {
			p.x=250;
			p.y=125;
		}
		else {
			p.x=0;
			p.y=0;
		}
		
	    

	    

		this.icon_boat = new ImageIcon(picture_boat);
		
		
		JImage car = new JImage(icon_boat);
		
		layeredPane.setLayer(panelBoat, 1);
		

		panelBoat.setBounds(p.x,p.y, picture_boat.getWidth(), picture_boat.getHeight()+10);
		

		panelBoat.add(car);
		layeredPane.add(panelBoat);
		
		
		
		
	}
	
	public void move(int y) {
		p.y += y;
		panelBoat.setBounds(p.x,p.y, picture_boat.getWidth(), picture_boat.getHeight()+10);
	}
	
	public void put(Point p) {
		this.p = p;
		panelBoat.setBounds(p.x,p.y, picture_boat.getWidth(), picture_boat.getHeight()+10);
		
	}
	

}
