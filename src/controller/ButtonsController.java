package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.View;

/**
 * @author Alexandre Leonardi
 *
 */
public class ButtonsController implements Runnable,ActionListener {

	/**
	 * @param window
	 */
	public ButtonsController(View window) {
		window.displayButtons();
	}


	public void run() {
		
	}


	public void actionPerformed(ActionEvent arg0) {
		
	}

}
