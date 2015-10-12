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
		
		this.picture_boat = ImageIO.read(new File("res/img/vehicles/boats/boat.png"));
		this.layeredPane = layeredPane;
		this.panelBoat = new JPanel();
		this.panelBoat.setOpaque(false);
		this.p = new Point();
		this.pos = pos;
		if(pos == Position.South) {
			p.x=540;
			p.y=590;
		}
		else if (pos == Position.North) {
			p.x=340;
			p.y=100;
		}
		else {
			p.x=0;
			p.y=0;
		}
		
	    

	    

		this.icon_boat = new ImageIcon(picture_boat);
		
		
		JImage boat = new JImage(icon_boat);
		
		layeredPane.setLayer(panelBoat, 1);
		

		panelBoat.setBounds(p.x,p.y, picture_boat.getWidth(), picture_boat.getHeight()+10);
		

		panelBoat.add(boat);
		layeredPane.add(panelBoat);
		
		
		
		
	}
	
	
	public void move(int y) {
		if(pos == Position.South)
			p.y -= y;
		else
			p.y +=y;
		panelBoat.setBounds(p.x,p.y, picture_boat.getWidth(), picture_boat.getHeight()+10);
		
		if(p.y==0 || p.y==700)
			hide();
		
	
		
	}
	
	public void put(Point p) {
		this.p = p;
		panelBoat.setBounds(p.x,p.y, picture_boat.getWidth(), picture_boat.getHeight()+10);
		
	}
	
	public void hide() {
		//panelBoat.setVisible(false); ne pas utiliser ceci car cela déplace le pont
		panelBoat.setBounds(p.x,p.y,0, 0);
		
	}
	

}
