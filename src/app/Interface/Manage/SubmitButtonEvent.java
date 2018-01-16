package app.Interface.Manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import app.Interface.Intf;
import app.Interface.ManageIntf;
import app.databases.SQLiteConnection;

public class SubmitButtonEvent extends ManageIntf implements ActionListener {

	final private JTextField nameArea;
	final private JTextField searchArea;
	final private JTextField firstNameArea;
	final private JTextField salarArea;
	final private JTextField postArea;
	final private JTextField teamArea;
	final private JTextField projectArea;
	final private JTextField dateArea;
	
	public SubmitButtonEvent(JFrame frame, JTextField nameArea, JTextField searchArea, JTextField firstNameArea,
			JTextField salarArea, JTextField postArea, JTextField teamArea, JTextField projectArea,
			JTextField dateArea) {
		super(frame);
		this.nameArea = nameArea;
		this.searchArea = searchArea;
		this.firstNameArea = firstNameArea;
		this.salarArea = salarArea;
		this.postArea = postArea;
		this.teamArea = teamArea;
		this.projectArea = projectArea;
		this.dateArea = dateArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final SQLiteConnection con = new SQLiteConnection();
		con.updateContent(searchArea.getText(),nameArea.getText(), firstNameArea.getText(), salarArea.getText(),
				postArea.getText(), teamArea.getText(), projectArea.getText(), dateArea.getText());
		
		final Intf intf = new ManageIntf(frame);
		intf.setInterface();
		
	}
	
	
	

	
}
