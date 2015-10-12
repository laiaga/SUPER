package view;

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

import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;

/**
 * The main JFrame containing the whole GUI
 * @author Loïc Vierin
 */
@SuppressWarnings("serial")
public class View extends JFrame{
	private JLayeredPane layeredPane;
	protected static int speed; //the speedrate of the animation   speed = 15: Nominal. speed = 1: Rapide

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		View window = new View();
		speed = 1;

		//CECI SERA DANS LE CONTROLEUR, IL S'AGIT ICI D'UN TEST =)
		//création voitures et bateaux
		//controleur:
		Car car1 = window.createCar(Position.EAST);
		Car car2 = null;
		Car car3 = null;
		Car car4 = null;
		Boat boat1 = window.createBoat(Position.NORTH);
		Boat boat2 = null;
		Boat boat3 = null;
		Boat boat4 = null;
		view.Bridge bridge = window.createBridge(BridgeState.DOWN);
		Barrier barrier= window.createBarrier(Position.EAST);
		Barrier barrier2= window.createBarrier(Position.WEST);
		
		Traffic_Tri traffic1 = window.create_traffic_tri(Position.EAST);
		Traffic_Tri traffic2 = window.create_traffic_tri(Position.WEST);
		Traffic_Bi traffic3 = window.create_traffic_bi(Position.NORTH);
		Traffic_Bi traffic4 = window.create_traffic_bi(Position.SOUTH);
		
		
		barrier.setOpen(); 
		barrier2.setOpen();
		

		traffic1.setRed();
		traffic2.setRed();
		traffic3.setRed();
		traffic4.setRed();
		
		barrier.close();
		barrier2.close();
		
		traffic1.setRed();
		traffic2.setRed();
		traffic3.setGreen();
		traffic4.setGreen();
		
		bridge.open();
		
		for(int i=0; i<=700; i++ ) {
			boat1.move(1);
			if(boat2!=null)
				boat2.move(1); 
			if(boat3!=null)
				boat3.move(2); //vitesse modifiable
			if(boat4!=null)
				boat4.move(1);
			Thread.sleep(speed);
			if(i==125)
				boat3 = window.createBoat(Position.SOUTH);
			
			if(i==200)
			{
				boat2 = window.createBoat(Position.NORTH);
				boat4 = window.createBoat(Position.SOUTH);
			}
		}
		
		boat1.hide();
		boat2.hide();
		boat3.hide();
		boat4.hide();
		
		
		bridge.close();
		barrier.open();
		barrier2.open();
		traffic1.setGreen();
		traffic2.setGreen();
		traffic3.setRed();
		traffic4.setRed();
		
		
		((JProgressBar) window.getContentPane().getComponent(2)).setValue(0);
		((JProgressBar) window.getContentPane().getComponent(2)).setMaximum(700);
		for(int i=0; i<=700; i++ ) {
			((JProgressBar) window.getContentPane().getComponent(2)).setValue(i);
			car1.move(1);
			if(car2!=null)
				car2.move(1); 
			if(car3!=null)
				car3.move(2); //vitesse modifiable
			if(car4!=null)
				car4.move(1);
			Thread.sleep(speed);
			if(i==125)
				car3 = window.createCar(Position.WEST);
			
			if(i==200)
			{
				car2 = window.createCar(Position.EAST);
				car4 = window.createCar(Position.WEST);
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
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(37, 23, 978, 775);
		getContentPane().add(layeredPane);
		
		
		try { 
			displayBackgroundImage();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		displayMenu();
		
		setProgressBar();
				
						
		JPanel panelStates = new JPanel();
		panelStates.setBounds(1041, 23, 141, 775);
		getContentPane().add(panelStates);
		layeredPane.setLayer(panelStates, 0);
		panelStates.setBackground(Color.LIGHT_GRAY);
		GridBagLayout gblPanelState = new GridBagLayout();
		gblPanelState.columnWidths = new int[] {37, 0};
		gblPanelState.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0, 0};
		gblPanelState.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gblPanelState.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelStates.setLayout(gblPanelState);
		
		JLabel lblNewLabel = new JLabel("STATES");
		lblNewLabel.setFont(new Font("Arimo", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelStates.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblCapteurV = new JLabel("Bridge Closed");
		lblCapteurV.setFont(new Font("Arimo", Font.PLAIN, 14));
		lblCapteurV.setForeground(Color.RED);
		GridBagConstraints gbc_lblCapteurV = new GridBagConstraints();
		gbc_lblCapteurV.insets = new Insets(0, 0, 5, 0);
		gbc_lblCapteurV.gridx = 0;
		gbc_lblCapteurV.gridy = 1;
		panelStates.add(lblCapteurV, gbc_lblCapteurV);
		setBackground(UIManager.getColor("Button.darkShadow"));
		setBounds(100, 100, 1218, 858);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	/**
	 * Creates a new car to display on screen
	 * @param p the position (East or West, relative to the bridge) of the car
	 * @return the Car created 
	 * @throws IOException in the case of the car image not being at the specified path
	 */
	public Car createCar(Position p) throws IOException {
		return (new Car(getLayeredPane(), p));
	}
	
	/**
	 * Creates a new boat to display on screen
	 * @param p the position (North or South, relative to the bridge) of the boat
	 * @return the Boat created 
	 * @throws IOException in the case of the boat image not being at the specified path
	 */
	public Boat createBoat(Position p) throws IOException {
		return (new Boat(getLayeredPane(), p));
	}
	

	/**
	 * Creates a bridge to display on screen
	 * @param s the state of the bridge at the begining of the simulation
	 * @return the bridge created
	 * @throws IOException if the bridge picture is not found at the specified path
	 */
	public view.Bridge createBridge(BridgeState s) throws IOException {
		return (new view.Bridge(getLayeredPane(), s));
	}
	
	/**
	 * Creates a new barrier to display on screen
	 * @param p the position (East or West, relative to the bridge) of the barrier
	 * @return the Barrier created 
	 * @throws IOException in the case of the barrier image not being at the specified path
	 */
	public Barrier createBarrier(Position p) throws IOException {
		return (new Barrier(getLayeredPane(), p));
	}
	
	
	/**
	 * Creates a new traffic light to display onscreen
	 * @param p
	 * @return
	 * @throws IOException
	 */
	public Traffic_Tri create_traffic_tri(Position p) throws IOException {
		return (new Traffic_Tri(getLayeredPane(), p));
	}
	
	public Traffic_Bi create_traffic_bi(Position p) throws IOException {
		return (new Traffic_Bi(getLayeredPane(), p));
	}

	/**
	 * Displays the background image on screen
	 * @throws IOException if the image is not at the specified path
	 */
	public void displayBackgroundImage() throws IOException{
		BufferedImage bufferedImgBackground = ImageIO.read(new File(ImagePath.BACKGROUND.toString()));
		JImage imgBackground = new JImage( new ImageIcon(bufferedImgBackground));
		imgBackground.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panelBackground = new JPanel();
		panelBackground.setBackground(Color.WHITE);
		layeredPane.setLayer(panelBackground, 0);
		panelBackground.setBounds(0, 0, 897, 773);
		layeredPane.add(panelBackground);
		
		panelBackground.add(imgBackground);
	}
	
	/**
	 * Displays the menu on screen
	 */
	public void displayMenu(){
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
	}
	
	public void setProgressBar(){
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0, 818, 1216, 14);
		getContentPane().add(progressBar);
		progressBar.setValue(50);
	}
}
