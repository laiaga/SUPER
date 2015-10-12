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
public class Barrier {
	
	private ImageIcon icon_barrier;
	private BufferedImage picture_barrier;
	private JLayeredPane layeredPane;
	private JPanel panelBarrier;
	private Position pos;
	private PositionBridge pos2;
	private Point p;
	
		
	public Barrier(JLayeredPane layeredPane, Position pos) throws IOException {
		
		this.picture_barrier = ImageIO.read(new File("res/img//barrier/barrier.png"));
		this.layeredPane = layeredPane;
		this.panelBarrier = new JPanel();
		this.panelBarrier.setOpaque(false);
		this.p = new Point();
		this.pos = pos;
		this.pos2 = PositionBridge.Down;
		if(pos == Position.East) {
			p.x=375;
			p.y=325;
		}
		else if (pos == Position.West) {
			p.x=-15;
			p.y=200;
		}
		else {
			p.x=0;
			p.y=0;
		}
		
	    

	    

		this.icon_barrier = new ImageIcon(picture_barrier);
		
		
		JImage barrier = new JImage(icon_barrier);
		
		layeredPane.setLayer(panelBarrier, 1);
		

		panelBarrier.setBounds(p.x,p.y, picture_barrier.getWidth(), picture_barrier.getHeight()+10);
		

		panelBarrier.add(barrier);
		layeredPane.add(panelBarrier);
		
		
		
		
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
	
	public void put(Point p) {
		this.p = p;
		panelBarrier.setBounds(p.x,p.y, picture_barrier.getWidth(), picture_barrier.getHeight()+10);
		
	}
	
	public void hide() {
		//panelBarrier.setVisible(false); ne pas utiliser ceci car cela déplace le pont
		panelBarrier.setBounds(p.x,p.y,0, 0);
		
	}
	

}
