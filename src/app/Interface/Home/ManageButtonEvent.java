package app.Interface.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import app.Interface.HomeInt;
import app.Interface.Intf;
import app.Interface.ManageIntf;

public class ManageButtonEvent extends HomeInt implements ActionListener {

	public ManageButtonEvent(JFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Intf intf = new ManageIntf(frame);
		intf.setInterface();
		
	}

}
