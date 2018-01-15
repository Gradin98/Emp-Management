package app;

import javax.swing.JFrame;

import app.Interface.HomeInt;
import app.Interface.Intf;

public class Main {

	public static void main(String args[]) {
		
		JFrame frame = new JFrame();
		
		Intf intf = new HomeInt(frame);
		intf.setInterface();
	}
}
