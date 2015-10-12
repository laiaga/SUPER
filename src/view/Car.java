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
public class Car {
	
	private ImageIcon icon_car;
	private BufferedImage picture_car_rotated;
	private JLayeredPane layeredPane;
	private JPanel panelCar;
	private Position pos;
	private Point p;
	
		
	public Car(JLayeredPane layeredPane, Position pos) throws IOException {
		
		BufferedImage picture_car = ImageIO.read(new File("res/img/vehicles/cars/car.png"));
		this.layeredPane = layeredPane;
		this.panelCar = new JPanel();
		this.panelCar.setOpaque(false);
		this.p = new Point();
		this.pos = pos;
		int rot=0;
		if(pos == Position.East) {
			p.x=200;
			p.y=345;
			rot=90;
		}
		else if (pos == Position.West) {
			p.x=600;
			p.y=405;
			rot=-90;
		}
		else {
			p.x=0;
			p.y=0;
		}
		
	    
	    AffineTransform xform = new AffineTransform();
	    xform.translate(0.5*picture_car.getHeight(), 0.5*picture_car.getWidth());
	    xform.rotate(Math.toRadians(rot));
	    xform.translate(-0.5*picture_car.getWidth(), -0.5*picture_car.getHeight());
	    
	    AffineTransformOp op = new AffineTransformOp(xform, AffineTransformOp.TYPE_BILINEAR);
	    this.picture_car_rotated = op.filter(picture_car, null);
	    

		this.icon_car = new ImageIcon(picture_car_rotated);
		
		
		JImage car = new JImage(icon_car);
		
		layeredPane.setLayer(panelCar, 1);
		

		panelCar.setBounds(p.x,p.y, picture_car_rotated.getWidth(), picture_car_rotated.getHeight()+10);

		panelCar.add(car);
		layeredPane.add(panelCar);
		
		
		
		
	}
	
	public void move(int x) {
		p.x += x;
		panelCar.setBounds(p.x,p.y, picture_car_rotated.getWidth(), picture_car_rotated.getHeight()+10);
	}
	
	public void put(Point p) {
		this.p = p;
		panelCar.setBounds(p.x,p.y, picture_car_rotated.getWidth(), picture_car_rotated.getHeight()+10);
		
	}
	

}
