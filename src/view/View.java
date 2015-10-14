package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controller.ButtonsController;

/**
 * The main JFrame containing the whole GUI
 * @author Loïc Vierin
 */
@SuppressWarnings("serial")
public class View extends JFrame{
	private JLayeredPane layeredPane;
	private JPanel panelStates;
	private JProgressBar progressBar;
	private Bridge bridge;
	private Barrier barrier_west;
	private Barrier barrier_east;
	private TrafficBi traffic_bi_north;
	private TrafficBi traffic_bi_south;
	private TrafficTri traffic_tri_west;
	private TrafficTri traffic_tri_east;
	private ButtonsColumn buttons;
	
	protected static int speed; //the speedrate of the animation   speed = 15: Nominal. speed = 1: Rapide

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	/*public static void main(String[] args) throws IOException, InterruptedException {

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
		
		TrafficTri traffic1 = window.createTrafficTri(Position.EAST);
		TrafficTri traffic2 = window.createTrafficTri(Position.WEST);
		TrafficBi traffic3 = window.createTrafficBi(Position.NORTH);
		TrafficBi traffic4 = window.createTrafficBi(Position.SOUTH);
		
		JLabel label_bridge = window.createLabelState();
		label_bridge.setText("Bridge Closed");
		
		JLabel label_sensor_west = window.createLabelState();
		label_sensor_west.setText("West sensor active");
		
		JLabel label_sensor_east = window.createLabelState();
		label_sensor_east.setText("East sensor inactive");
		label_sensor_east.setForeground(Color.green);
		

		
		
		barrier.setOpen(); 
		barrier2.setOpen();
		


		
		
		traffic1.setOrange();
		traffic2.setOrange();
		Thread.sleep(1000);
		traffic1.setRed();
		traffic2.setRed();
		traffic3.setGreen();
		traffic4.setGreen();
		

		barrier.close();
		barrier2.close();
		
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
		
		traffic1.setRed();
		traffic2.setRed();
		traffic3.setRed();
		traffic4.setRed();
		
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
		
	}*/

	/**
	 * Initialize the contents of the frame.
	 */
	public View() {
		super();
		

		this.progressBar = new JProgressBar();
		try {
			
			this.bridge = createBridge(BridgeState.DOWN);
			this.barrier_west = createBarrier(Position.WEST);
			this.barrier_east = createBarrier(Position.EAST);
			this.traffic_bi_north = createTrafficBi(Position.NORTH);
			this.traffic_bi_south = createTrafficBi(Position.SOUTH);
			traffic_bi_north.setRed();
			traffic_bi_south.setRed();
			this.traffic_tri_east = createTrafficTri(Position.EAST);
			this.traffic_tri_west = createTrafficTri(Position.WEST);
		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		barrier_east.setOpen();
		barrier_west.setOpen();
		
		speed=1;
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(37, 23, 978, 775);
		getContentPane().add(layeredPane);
		

		JPanel panelStates = new JPanel();
		panelStates.setBounds(1041, 23, 141, 775);
		getContentPane().add(panelStates);
		layeredPane.setLayer(panelStates, 0);
		panelStates.setBackground(Color.WHITE);
		GridBagLayout gblPanelState = new GridBagLayout();
		gblPanelState.columnWidths = new int[] {37, 0};
		gblPanelState.rowHeights = new int[]{15, 0, 0, 0, 0, 0, 0, 0};
		gblPanelState.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gblPanelState.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelStates.setLayout(gblPanelState);
		
		
		try { 
			displayBackgroundImage();			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		displayMenu();
		
				
						

		
		JLabel lblNewLabel = new JLabel("STATES");
		//lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arimo", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelStates.add(lblNewLabel, gbc_lblNewLabel);
		
		
		

		
		setBackground(UIManager.getColor("Button.darkShadow"));
		setBounds(100, 100, 1218, 858);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//displayButtons();
		
		
		
	}
	
	
	/**
	 * Creates a new LabelState
	 * @return the JLabel created
	 */
	public JLabel createLabelState(String label, Color background)
	{
		
		JLabel lblCapteur = new JLabel(label);
		lblCapteur.setFont(new Font("Arimo", Font.BOLD, 14));
		lblCapteur.setForeground(Color.BLACK);
		
		lblCapteur.setBackground(background);
		lblCapteur.setOpaque(true);

		lblCapteur.setHorizontalAlignment(SwingConstants.LEFT);
		
		GridBagConstraints gbc_lblCapteur = new GridBagConstraints();
		gbc_lblCapteur.insets = new Insets(0, 0, 5, 0);
		
		gbc_lblCapteur.gridx = 0;
		gbc_lblCapteur.gridy = ((JPanel) this.getContentPane().getComponent(1)).getComponentCount();
		((JPanel) this.getContentPane().getComponent(1)).add(lblCapteur, gbc_lblCapteur);
		
		revalidate();

		
		return lblCapteur;
	}
	
	/**
	 * Creates the button panel on the right of the window
	 * @param buttonsController 
	 * @param contentPane
	 */
	public ButtonsColumn createButtonsColumn(ButtonsController buttonsController) {
		buttons = new ButtonsColumn(buttonsController);
		return new ButtonsColumn(buttonsController);
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
	public TrafficTri createTrafficTri(Position p) throws IOException {
		return (new TrafficTri(getLayeredPane(), p));
	}
	
	public TrafficBi createTrafficBi(Position p) throws IOException {
		return (new TrafficBi(getLayeredPane(), p));
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
		progressBar.setBounds(0, 818, 1216, 14);
		getContentPane().add(progressBar);
		progressBar.setValue(50);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1216, 23);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Actions");
		mnNewMenu.setFont(new Font("Arimo", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.setFont(new Font("Arimo", Font.PLAIN, 14));
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane jop = new JOptionPane();	
				
				int choix = jop.showConfirmDialog (null, "Voulez-vous quitter ?", "Quitter", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if(choix == JOptionPane.YES_OPTION){
					System.exit(0);
				}
				
				
				
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("More");
		mnNewMenu_1.setFont(new Font("Arimo", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1); 
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Infos");
		mntmNewMenuItem_1.setFont(new Font("Arimo", Font.PLAIN, 14));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop1 = new JOptionPane();
				String str = "VIERIN Loic, LEONARDI Alexandre, DUGAT Ghislain, LEPETIT Gélaud, BENAMEUR Abdelkader";
				jop1.showMessageDialog(null, str, "Information", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
	}


	public JProgressBar getProgressBar() {
		return progressBar;
	}


	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}


	public Bridge getBridge() {
		return bridge;
	}


	public void setBridge(Bridge bridge) {
		this.bridge = bridge;
	}


	public Barrier getBarrier_west() {
		return barrier_west;
	}


	public void setBarrier_west(Barrier barrier_west) {
		this.barrier_west = barrier_west;
	}


	public Barrier getBarrier_east() {
		return barrier_east;
	}


	public void setBarrier_east(Barrier barrier_east) {
		this.barrier_east = barrier_east;
	}


	public TrafficBi getTraffic_bi_north() {
		return traffic_bi_north;
	}


	public void setTraffic_bi_north(TrafficBi traffic_bi_north) {
		this.traffic_bi_north = traffic_bi_north;
	}


	public TrafficBi getTraffic_bi_south() {
		return traffic_bi_south;
	}


	public void setTraffic_bi_south(TrafficBi traffic_bi_south) {
		this.traffic_bi_south = traffic_bi_south;
	}


	public TrafficTri getTraffic_tri_west() {
		return traffic_tri_west;
	}


	public void setTraffic_tri_west(TrafficTri traffic_tri_west) {
		this.traffic_tri_west = traffic_tri_west;
	}


	public TrafficTri getTraffic_tri_east() {
		return traffic_tri_east;
	}


	public void setTraffic_tri_east(TrafficTri traffic_tri_east) {
		this.traffic_tri_east = traffic_tri_east;
	}


	public static int getSpeed() {
		return speed;
	}


	public static void setSpeed(int speed) {
		View.speed = speed;
	}
	public ButtonsColumn getButtons(){
		return buttons;
	}
	public void setButtons(ButtonsColumn buttons){
		this.buttons = buttons;
	}

}
