package app.Interface.Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import app.Interface.ManageIntf;
import app.Interface.components.DataPicker;

public class DateButtonEvent extends ManageIntf implements ActionListener {

	private JTextField dateArea;

	public DateButtonEvent(JFrame frame, JTextField dateArea) {
		super(frame);
		this.dateArea = dateArea;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		dateArea.setText(new DataPicker(f).setPickedDate());
		
	}

	
}
