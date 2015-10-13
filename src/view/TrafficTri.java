package view;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import view.ColorLights.ColorTri;

/**
 * Modelization of the bridge
 * @author Loic Vierin
 */
@SuppressWarnings("serial")
public class TrafficTri extends JPanel {
	
	private BufferedImage bufferedImgBridge;
	private JImage imgBridge;
	private JLayeredPane layeredPane;
	private Position pos;
	private ColorTri color;
	private Point p;
	
	public Position getPos() {
		return pos;
	}
		
	public TrafficTri(JLayeredPane layeredPane, Position pos) throws IOException {
		super();
		
		bufferedImgBridge = ImageIO.read(new File(ImagePath.TRAFFIC.toString()+"green.png"));
		this.layeredPane = layeredPane;
		this.setOpaque(false);
		p = new Point();
		this.pos = pos;
		color = ColorTri.VERT;
		
		if(pos == Position.EAST) {
			p.x=190;
			p.y=230;
		}
		
		else if(pos == Position.WEST) {
			p.x=710;
			p.y=500;
		}
		
		else {
			p.x =0;
			p.y = 0;
		}
		
		
		imgBridge = new JImage(new ImageIcon(bufferedImgBridge));
		
		this.layeredPane.setLayer(this, 0);
		
		this.setBounds(p.x,p.y, bufferedImgBridge.getWidth(), bufferedImgBridge.getHeight()+10);
		
		this.add(imgBridge);
		this.layeredPane.add(this);
		System.out.println("New Traffic Tricolor "+ pos);
	}
	
	/**
	 * Turn the traffic Light red
	 */
	public void setRed() {
		this.color = ColorTri.ROUGE;
		try {
			bufferedImgBridge = ImageIO.read(new File(ImagePath.TRAFFIC.toString()+"red.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgBridge.setIcon(new ImageIcon(bufferedImgBridge));
		System.out.println("Traffic Tricolor " + pos + ": " + color );
	}
	
	/**
	 * Turn the traffic Light orange
	 */
	public void setOrange() {
		this.color = ColorTri.ORANGE;
		try {
			bufferedImgBridge = ImageIO.read(new File(ImagePath.TRAFFIC.toString()+"orange.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgBridge.setIcon(new ImageIcon(bufferedImgBridge));
		System.out.println("Traffic Tricolor " + pos + ": " + color );
	}
	
	/**
	 * Turn the traffic Light green
	 */
	public void setGreen() {
		this.color = ColorTri.VERT;
		try {
			bufferedImgBridge = ImageIO.read(new File(ImagePath.TRAFFIC.toString()+"green.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgBridge.setIcon(new ImageIcon(bufferedImgBridge));
		System.out.println("Traffic Tricolor " + pos + ": " + color );
	}
	
	
	

}
