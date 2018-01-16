package app.Interface.Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import app.Interface.Intf;
import app.Interface.ManageIntf;
import app.databases.SQLiteConnection;

public class DeleteButtonEvent extends ManageIntf implements ActionListener {

	private JTextField searchArea;
	
	public DeleteButtonEvent(JFrame frame, JTextField searchArea) {
		super(frame);
		this.searchArea = searchArea;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		SQLiteConnection con = new SQLiteConnection();
		con.deleteEmp(searchArea.getText());

		Intf intf = new ManageIntf(frame);
		intf.setInterface();
		
	}
	
	

}
