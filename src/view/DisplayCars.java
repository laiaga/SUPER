package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class DisplayCars {
	
	private JLayeredPane layeredPane;
	
	public DisplayCars(JLayeredPane layeredPane){
		this.layeredPane = layeredPane;
		
	}
	
	public JCar createCar() throws IOException{
		BufferedImage picture_car = ImageIO.read(new File("res/img/vehicles/cars/car.png"));
		JCar car = new JCar( new ImageIcon(picture_car));
		
		JPanel panel_car = new JPanel();
		layeredPane.setLayer(panel_car, 1);
		panel_car.setBounds(200, 300, picture_car.getWidth(), picture_car.getHeight()+10);
		layeredPane.add(panel_car);
		
		panel_car.add(car);
		
		return car;
	}

}
