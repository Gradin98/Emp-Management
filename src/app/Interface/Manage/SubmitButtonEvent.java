package app.Interface.Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import app.Interface.ManageIntf;

public class SubmitButtonEvent extends ManageIntf implements ActionListener {

	public SubmitButtonEvent(JFrame frame) {
		super(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ceva");
		
	}
	
	

	
}
