package app.Interface.Add;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import app.Logs;
import app.Interface.AddInt;
import app.Interface.HomeInt;
import app.Interface.Intf;

/**
 * 
 * Clasa care seteaza MouseListeneruListeneru pentru butonul de back necesar pentru revenirea la meniul de home
 * Mostene clasa AddInt
 * 
 * @author Kocsis Lorand
 *
 */
public class BackButtonEvent extends AddInt implements MouseListener {

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
