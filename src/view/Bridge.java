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
public class Bridge {
	
	private ImageIcon icon_bridge;
	private BufferedImage picture_bridge;
	private JLayeredPane layeredPane;
	private JPanel panelBridge;
	private PositionBridge pos;
	private Point p;
	
		
	public Bridge(JLayeredPane layeredPane, PositionBridge pos) throws IOException {
		
		this.picture_bridge = ImageIO.read(new File("res/img/bridge/bridge2.png"));
		this.layeredPane = layeredPane;
		this.panelBridge = new JPanel();
		this.panelBridge.setOpaque(false);
		this.p = new Point();
		this.pos = pos;
		
		p.x=280;
		p.y=325;
		
	    

	    

		this.icon_bridge = new ImageIcon(picture_bridge);
		
		
		JImage bridge = new JImage(icon_bridge);
		
		layeredPane.setLayer(panelBridge, 0);
		

		panelBridge.setBounds(p.x,p.y, picture_bridge.getWidth(), picture_bridge.getHeight()+10);
		

		panelBridge.add(bridge);
		layeredPane.add(panelBridge);
		
		
		
		
	}
	
	public void close() {
		this.pos = PositionBridge.Moving;
		try {
			int w = 0;
			for(int i=0; i<picture_bridge.getWidth(); i++) {
				w++;
				this.panelBridge.setSize(w, picture_bridge.getHeight()+10);

				Thread.sleep(15);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pos=PositionBridge.Down;
		
			
	}
	
	public void open() {
		this.pos = PositionBridge.Moving;
		try {
			int w = picture_bridge.getWidth();
			for(int i=0; i<picture_bridge.getWidth(); i++) {
				w--;
				this.panelBridge.setSize(w, picture_bridge.getHeight()+10);

				Thread.sleep(15);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.pos=PositionBridge.Up;
		
			
	}
	
	public void setOpen() {
		this.panelBridge.setSize(0, picture_bridge.getHeight()+10);
	}
	
	public void setClose() {
		this.panelBridge.setSize(picture_bridge.getWidth(), picture_bridge.getHeight()+10);
	}
	

}
