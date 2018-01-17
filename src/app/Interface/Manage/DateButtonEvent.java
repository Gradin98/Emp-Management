package app.Interface.Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import app.Logs;
import app.Interface.ManageIntf;
import app.Interface.components.DataPicker;

/**
 * 
 * Clasa care seteaza Listeneru pentru datePicker
 * Mostene clasa ManageIntf
 * 
 * @author Kocsis Lorand
 *
 */

public class DateButtonEvent extends ManageIntf implements ActionListener {

	final private JTextField dateArea;

	public DateButtonEvent(JFrame frame, JTextField dateArea) {
		super(frame);
		this.dateArea = dateArea;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Logs.setLog("Open datePicker");

		dateArea.setText(new DataPicker(f).setPickedDate());
		
	}

	
}
