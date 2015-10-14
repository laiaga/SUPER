package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.View;

/**
 * @author Alexandre Leonardi
 *
 */
public class ButtonsController implements Runnable,ActionListener {

	private View window;


	/**
	 * @param window
	 */
	public ButtonsController(View window) {
		this.window = window;
		window.createButtonsColumn(this);
	}


	public void run() {
		
	}


	public void actionPerformed(ActionEvent arg0) {
		JButton j = (JButton)arg0.getSource();
		
		if(j.getName() == "maintenance"){
			System.out.println(j.getName());
			window.getButtons().setVisible(false);
			window.getButtons().dispose();
		}
	}

}
