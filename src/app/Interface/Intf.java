package app.Interface;

import javax.swing.JFrame;

public class Intf {

	final protected JFrame frame;
	
	public Intf(JFrame frame) {
		this.frame = frame;
	}

	public void setInterface() {
		
	}
	
	public void setFrame() {
		frame.setLayout(null);
		frame.setSize(750, 400);
		frame.setVisible(true);
	}
	
	public void clearFrame() {
		frame.getContentPane().removeAll();
		frame.repaint();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
