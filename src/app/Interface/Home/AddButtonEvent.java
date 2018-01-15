package app.Interface.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import app.Interface.AddInt;
import app.Interface.HomeInt;
import app.Interface.Intf;

public class AddButtonEvent extends HomeInt implements ActionListener {

	public AddButtonEvent(JFrame frame) {
		super(frame);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Intf intf = new AddInt(frame);
		intf.setInterface();
		
	}

}
