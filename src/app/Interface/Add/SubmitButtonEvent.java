package app.Interface.Add;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
		
		if(!checkNumber(salarArea.getText())) {
			salarArea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return;
		}
		
		if(!checkAlphabet(nameArea.getText())) {
			nameArea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return;
		}
		
		if(!checkAlphabet(firstNameArea.getText())) {
			firstNameArea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return;
		}
		
		if(!checkAlphabet(postArea.getText())) {
			postArea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return;
		}
		
		if(!checkAlphabet(teamArea.getText())) {
			teamArea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return;
		}
		
		SQLiteConnection con = new SQLiteConnection();
		con.setContent(nameArea.getText(), firstNameArea.getText(), salarArea.getText(), postArea.getText(),
				teamArea.getText(), projectArea.getText(), dateArea.getText());
		Intf intf = new AddInt(frame);
		intf.setInterface();

	}
	
	public boolean checkNumber(String text) {
		if(text.matches("^[0-9]*$")) {
			return true;
		}
		return false;
	}
	
	public boolean checkAlphabet(String text) {
		if(text.matches("^[ A-Za-z]+$")) {
			return true;
		}
		return false;
	}
	

}
