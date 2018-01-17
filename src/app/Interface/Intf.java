package app.Interface;

import javax.swing.JFrame;

/**
 * 
 * Clasa principala pentru interfata
 * 
 * @author Kocsis Lorand
 *
 */
public class Intf {

	final protected JFrame frame;

	public Intf(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Functie care simuleaza virtualizarea necesara pentru clasele care mostenesc
	 * aceastaclasa direct, aceasta functie seteaza obiectele in interfata
	 */
	public void setInterface() {

	}

	/**
	 * Functie care seteaza setarile pentru frame
	 */
	public void setFrame() {
		frame.setLayout(null);
		frame.setSize(750, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Functie care sterge toate obiectele din frmae
	 */
	public void clearFrame() {
		frame.getContentPane().removeAll();
		frame.repaint();

	}

}
