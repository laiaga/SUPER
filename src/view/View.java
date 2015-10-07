/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
 * @author Loïc Vierin
 *
 */
public class View {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		

		
try { 
		
		DisplayCars displayCars = new DisplayCars(layeredPane);
		displayCars.createCar();
		
			
			
			/////////////////////////////
			
			
			BufferedImage picture_boat = ImageIO.read(new File("res/img/vehicles/boats/boat.png"));
			JLabel boat = new JLabel( new ImageIcon(picture_boat));
			boat.setHorizontalAlignment(SwingConstants.CENTER);
			boat.setText("");
			
			JPanel Panel_boat = new JPanel();
			layeredPane.setLayer(Panel_boat, 1);
			Panel_boat.setBounds(500, 450, picture_boat.getWidth(), picture_boat.getHeight()+10);
			layeredPane.add(Panel_boat);
			
			
			//////////////////////////////
			
			
			BufferedImage picture_bg = ImageIO.read(new File("res/img/background/background.png"));
			JLabel bg = new JLabel( new ImageIcon(picture_bg));
			bg.setHorizontalAlignment(SwingConstants.CENTER);
			bg.setText("");

			JPanel Panel_bg = new JPanel();
			layeredPane.setLayer(Panel_bg, 0);
			Panel_bg.setBounds(0, 0, 897, 773);
			layeredPane.add(Panel_bg);
			
			
			
			
			
			
			
			Panel_bg.add(bg);
			Panel_boat.add(boat);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

		
		JPanel panel_states = new JPanel();
		panel_states.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_states, BorderLayout.EAST);
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
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
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
		frame.getContentPane().add(progressBar, BorderLayout.SOUTH);
		progressBar.setValue(50);
		frame.setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
