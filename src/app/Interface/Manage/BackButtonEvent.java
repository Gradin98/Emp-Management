package app.Interface.Manage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import app.Logs;
import app.Interface.HomeInt;
import app.Interface.Intf;
import app.Interface.ManageIntf;

public class BackButtonEvent extends ManageIntf implements MouseListener {

	public BackButtonEvent(JFrame frame) {
		super(frame);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		Logs.setLog("Enter to home menu");
		
		Intf intf = new HomeInt(frame);
		intf.setInterface();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
