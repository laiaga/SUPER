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
 * Modelization of the bridge
 * @author Loic Vierin
 */
@SuppressWarnings("serial")
public class Bridge extends JPanel {
	
	private BufferedImage bufferedImgBridge;
	private JImage imgBridge;
	private JLayeredPane layeredPane;
	private BridgeState pos;
	private Point p;
	
	public BridgeState getPos() {
		return pos;
	}
		
	public Bridge(JLayeredPane layeredPane, BridgeState pos) throws IOException {
		super();
		
		bufferedImgBridge = ImageIO.read(new File(ImagePath.BRIDGE.toString()));
		this.layeredPane = layeredPane;
		this.setOpaque(false);
		p = new Point();
		this.pos = pos;
		
		p.x=280;
		p.y=325;
		
		imgBridge = new JImage(new ImageIcon(bufferedImgBridge));
		
		this.layeredPane.setLayer(this, 0);
		
		this.setBounds(p.x,p.y, bufferedImgBridge.getWidth(), bufferedImgBridge.getHeight()+10);
		
		this.add(imgBridge);
		this.layeredPane.add(this);
	}
	
	/**
	 * Closes the bridge i.e. lower the deck
	 * At the end of the operation, cars can go through, boats are blocked
	 */
	public void close() {
		if(pos == BridgeState.UP) {
			pos = BridgeState.MOVING;
			try {
				int width = 0;
				for(int i=0; i<bufferedImgBridge.getWidth(); i++) {
					width++;
					this.setSize(width, bufferedImgBridge.getHeight()+10);
	
					//Thread.sleep(15);
					Thread.sleep(View.speed);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pos=BridgeState.DOWN;	
		}
		else 
			System.err.println("Error: Bridge already closed !");
	}
	
	/**
	 * Opens the bridge i.e. rises the deck
	 * At the end of the operation, boats can go through, cars are blocked
	 */
	public void open() {
		if( pos == BridgeState.DOWN) {
			pos = BridgeState.MOVING;
			try {
				int width = bufferedImgBridge.getWidth();
				for(int i=0; i<bufferedImgBridge.getWidth(); i++) {
					width--;
					this.setSize(width, bufferedImgBridge.getHeight()+10);
	
					Thread.sleep(View.speed);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pos=BridgeState.UP;		
		}
		else
			System.err.println("Bridge already up!");
	}
	
	/**
	 * Resizes the panel when the bridge is open
	 */
	public void setOpen() {
		this.setSize(0, bufferedImgBridge.getHeight()+10);
	}
	
	/**
	 * Resizes the panel when the bridge is closed
	 */
	public void setClose() {
		this.setSize(bufferedImgBridge.getWidth(), bufferedImgBridge.getHeight()+10);
	}
	

}
