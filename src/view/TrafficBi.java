package view;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.ColorLights.ColorBi;
import view.ColorLights.ColorTri;

/**
 * Modelization of the bridge
 * @author Loic Vierin
 */
@SuppressWarnings("serial")
public class TrafficBi extends JPanel {
	
	private BufferedImage bufferedImgBridge;
	private JImage imgBridge;
	private JLayeredPane layeredPane;
	private Position pos;
	private ColorBi color;
	private Point p;
	
	public Position getPos() {
		return pos;
	}
		
	public TrafficBi(JLayeredPane layeredPane, Position pos) throws IOException {
		super();
		
		bufferedImgBridge = ImageIO.read(new File(ImagePath.TRAFFIC.toString()+"green.png"));
		this.layeredPane = layeredPane;
		this.setOpaque(false);
		p = new Point();
		this.pos = pos;
		color = ColorBi.VERT;
		
		
		if(pos == Position.NORTH) {
			p.x=190;
			p.y=110;
		}
		
		else if(pos == Position.SOUTH) {
			p.x=710;
			p.y=620;
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
	}
	
	
	/**
	 * Turn the traffic Light red
	 */
	public void setRed() {
		this.color = ColorBi.ROUGE;
		try {
			bufferedImgBridge = ImageIO.read(new File(ImagePath.TRAFFIC.toString()+"red.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgBridge.setIcon(new ImageIcon(bufferedImgBridge));
	}

	/**
	 * Turn the traffic Light green
	 */
	public void setGreen() {
		this.color = ColorBi.VERT;
		try {
			bufferedImgBridge = ImageIO.read(new File(ImagePath.TRAFFIC.toString()+"green.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgBridge.setIcon(new ImageIcon(bufferedImgBridge));
	}

	public ColorBi getColor() {
		return color;
	}

	public Point getP() {
		return p;
	}
	
	
	

}
