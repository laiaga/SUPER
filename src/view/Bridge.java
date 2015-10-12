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
		
		p.x=240;
		p.y=325;
		
	    

	    

		this.icon_bridge = new ImageIcon(picture_bridge);
		
		
		JImage bridge = new JImage(icon_bridge);
		
		layeredPane.setLayer(panelBridge, 0);
		

		panelBridge.setBounds(p.x,p.y, picture_bridge.getWidth(), picture_bridge.getHeight()+10);
		

		panelBridge.add(bridge);
		layeredPane.add(panelBridge);
		
		
		
		
	}
	

	

}
