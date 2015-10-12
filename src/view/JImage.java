package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * A child of JLabel that encapsulates an image (as an ImageIcon)
 * @author Loïc Vierin
 */
@SuppressWarnings("serial")
public class JImage extends JLabel {

	public JImage(){
		super();
	}
	
	public JImage(ImageIcon imageIcon) {
		super(imageIcon);
	}

}
