package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class DisplayCars {
	ImageIcon icon_car;
	BufferedImage picture_car;
	
	private JLayeredPane layeredPane;
	
	public DisplayCars(JLayeredPane layeredPane) throws IOException{
		picture_car = ImageIO.read(new File("res/img/vehicles/cars/car.png"));
		icon_car = new ImageIcon(picture_car);
		this.layeredPane = layeredPane;
		
	}
	
	public JCar createCar(String pos) {
		JCar car = new JCar(icon_car);
		
		JPanel panel_car = new JPanel();
		layeredPane.setLayer(panel_car, 1);
		panel_car.setBounds(200, 300, picture_car.getWidth(), picture_car.getHeight()+10);
		layeredPane.add(panel_car);
		
		panel_car.add(car);
		
		return car;
	}

}
