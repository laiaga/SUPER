package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import test.Bridge;

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;

/**
 * @author Loïc Vierin
 *
 */
public class View extends JFrame{	

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		View window = new View();

		//CECI SERA DANS LE CONTROLEUR, IL S'AGIT ICI D'UN TEST =)
		//création voitures et bateaux
		Car car1 = window.create_car(Position.East);
		Car car2 = null;
		Car car3 = null;
		Car car4 = null;
		Boat boat1 = window.create_boat(Position.North);
		Boat boat2 = null;
		Boat boat3 = null;
		Boat boat4 = null;
		view.Bridge bridge = window.create_bridge(PositionBridge.Down);
		
		bridge.open();
		
		for(int i=0; i<=700; i++ ) {
			boat1.move(1);
			if(boat2!=null)
				boat2.move(1); 
			if(boat3!=null)
				boat3.move(2); //vitesse modifiable
			if(boat4!=null)
				boat4.move(1);
			Thread.sleep(15);
			if(i==125)
				boat3 = window.create_boat(Position.South);
			
			if(i==200)
			{
				boat2 = window.create_boat(Position.North);
				boat4 = window.create_boat(Position.South);
			}
		}
		
		boat1.hide();
		boat2.hide();
		boat3.hide();
		boat4.hide();
		
		
		bridge.close();
		
		for(int i=0; i<=700; i++ ) {
		car1.move(1);
		if(car2!=null)
			car2.move(1); 
		if(car3!=null)
			car3.move(2); //vitesse modifiable
		if(car4!=null)
			car4.move(1);
		Thread.sleep(15);
		if(i==125)
			car3 = window.create_car(Position.West);
		
		if(i==200)
		{
			car2 = window.create_car(Position.East);
			car4 = window.create_car(Position.West);
		}
		
	}

		car1.hide();
		car2.hide();
		car3.hide();
		car4.hide();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public View() {
		super();
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(37, 23, 978, 775);
		getContentPane().add(layeredPane);
		
		
		try { 
			
			
			
			BufferedImage picture_bg = ImageIO.read(new File("res/img/background/background.png"));
			JLabel bg = new JLabel( new ImageIcon(picture_bg));
			bg.setHorizontalAlignment(SwingConstants.CENTER);

			JPanel Panel_bg = new JPanel();
			Panel_bg.setBackground(Color.WHITE);
			layeredPane.setLayer(Panel_bg, 0);
			Panel_bg.setBounds(0, 0, 897, 773);
			layeredPane.add(Panel_bg);
			
			Panel_bg.add(bg);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1216, 23);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Actions");
		mnNewMenu.setFont(new Font("Arimo", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.setFont(new Font("Arimo", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("More");
		mnNewMenu_1.setFont(new Font("Arimo", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Infos");
		mntmNewMenuItem_1.setFont(new Font("Arimo", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 818, 1216, 14);
		getContentPane().add(progressBar);
		progressBar.setValue(50);
				
						
		JPanel panel_states = new JPanel();
		panel_states.setBounds(1041, 23, 141, 775);
		getContentPane().add(panel_states);
		layeredPane.setLayer(panel_states, 0);
		panel_states.setBackground(Color.WHITE);
		GridBagLayout gbl_panel_states = new GridBagLayout();
		gbl_panel_states.columnWidths = new int[] {37, 0};
		gbl_panel_states.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_states.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_states.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_states.setLayout(gbl_panel_states);
		
		JLabel lblNewLabel = new JLabel("STATES");
		lblNewLabel.setFont(new Font("Arimo", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_states.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblCapteurV = new JLabel("Bridge Closed");
		lblCapteurV.setFont(new Font("Arimo", Font.PLAIN, 14));
		lblCapteurV.setForeground(Color.RED);
		GridBagConstraints gbc_lblCapteurV = new GridBagConstraints();
		gbc_lblCapteurV.insets = new Insets(0, 0, 5, 0);
		gbc_lblCapteurV.gridx = 0;
		gbc_lblCapteurV.gridy = 1;
		panel_states.add(lblCapteurV, gbc_lblCapteurV);
		setBackground(UIManager.getColor("Button.darkShadow"));
		setBounds(100, 100, 1218, 858);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public Car create_car(Position p) throws IOException {
		return (new Car(getLayeredPane(), p));
		
	}
	
	public Boat create_boat(Position p) throws IOException {
		return (new Boat(getLayeredPane(), p));
		
	}
	

	public view.Bridge create_bridge(PositionBridge p) throws IOException {
		return (new view.Bridge(getLayeredPane(), p));
	}
	

}
