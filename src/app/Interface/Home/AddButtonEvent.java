package app.Interface.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import app.Logs;
import app.Interface.AddInt;
import app.Interface.HomeInt;
import app.Interface.Intf;

/**
 * 
 * Clasa care seteaza ActionListeneru pentru butonul de Add Emp
 * Mostene clasa HomeInt
 * 
 * @author Kocsis Lorand
 *
 */

public class AddButtonEvent extends HomeInt implements ActionListener {

	public AddButtonEvent(JFrame frame) {
		super(frame);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Logs.setLog("Enter to add menu");
		
		final Intf intf = new AddInt(frame);
		intf.setInterface();
		
	}

}
