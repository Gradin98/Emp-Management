package app.Interface.Add;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import app.Interface.AddInt;
import app.Interface.Intf;
import app.databases.SQLiteConnection;

/**
 * 
 * Clasa care seteaza Action Listeneru pentru butonul de submit din clasa AddInt
 * Mostene clasa AddInt
 * 
 * @author Kocsis Lorand
 *
 */

public class SubmitButtonEvent extends AddInt implements ActionListener {

	final private JTextField nameArea;
	final private JTextField firstNameArea;
	final private JTextField salarArea;
	final private JTextField postArea;
	final private JTextField teamArea;
	final private JTextField projectArea;
	final private JTextField dateArea;

	public SubmitButtonEvent(JFrame frame, JTextField nameArea, JTextField firstNameArea, JTextField salarArea,
			JTextField postArea, JTextField teamArea, JTextField projectArea, JTextField dateArea) {
		super(frame);
		this.nameArea = nameArea;
		this.firstNameArea = firstNameArea;
		this.salarArea = salarArea;
		this.postArea = postArea;
		this.teamArea = teamArea;
		this.projectArea = projectArea;
		this.dateArea = dateArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SQLiteConnection con = new SQLiteConnection();
		con.setContent(nameArea.getText(), firstNameArea.getText(), salarArea.getText(), postArea.getText(),
				teamArea.getText(), projectArea.getText(), dateArea.getText());
		Intf intf = new AddInt(frame);
		intf.setInterface();

	}

}
