package app.Interface.Add;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import app.Interface.AddInt;
import app.Interface.HomeInt;
import app.Interface.Intf;

public class BackButtonEvent extends AddInt implements MouseListener {

	public BackButtonEvent(JFrame frame) {
		super(frame);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
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
