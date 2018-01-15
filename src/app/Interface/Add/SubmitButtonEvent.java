package app.Interface.Add;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import app.Interface.AddInt;

public class SubmitButtonEvent extends AddInt implements ActionListener {

	public SubmitButtonEvent(JFrame frame) {
		super(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("ceva");
		
	}
	
	

	
}
