package app.Interface.Manage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;

import app.Interface.Intf;
import app.Interface.ManageIntf;
import app.databases.SQLiteConnection;


/**
 * 
 * Clasa care seteaza ActionListeneru pentru butonul de submit necesar pentru actualizarea datelor
 * Mostene clasa ManageIntf
 * 
 * @author Kocsis Lorand
 *
 */

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
		
		con.updateContent(searchArea.getText(),nameArea.getText(), firstNameArea.getText(), salarArea.getText(),
				postArea.getText(), teamArea.getText(), projectArea.getText(), dateArea.getText());
		
		final Intf intf = new ManageIntf(frame);
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
