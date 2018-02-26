package app.Interface.Manage;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;

import app.Emp;
import app.Interface.ManageIntf;
import app.databases.SQLiteConnection;

/**
 * 
 * Clasa care seteaza ActionListeneru pentru butonul de search, daca gaseste se afieaza meniul de manage
 * Mostene clasa ManageIntf
 * 
 * @author Kocsis Lorand
 *
 */

public class SearchButtonEvent extends ManageIntf implements ActionListener {

	final private JTextField nameArea;
	final private JTextField searchArea;
	final private JTextField firstNameArea;
	final private JTextField salarArea;
	final private JTextField postArea;
	final private JTextField teamArea;
	final private JTextField projectArea;
	final private JTextField dateArea;

	public SearchButtonEvent(JFrame frame, JTextField nameArea, JTextField searchArea, JTextField firstNameArea,
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
		SQLiteConnection con = new SQLiteConnection();

		if(!checkNumber(searchArea.getText())) {
			searchArea.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
			return;
		}
		
		if (searchArea.getText() != "") {
			
			searchArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			
			Emp emp = con.getEmpByID(searchArea.getText());

			if (emp != null) {
				Component[] cmp = frame.getContentPane().getComponents();
				for (Component c : cmp) {
					c.setVisible(true);
				}

				nameArea.setText(emp.getName());
				firstNameArea.setText(emp.getFirstname());
				salarArea.setText(emp.getSalary());
				postArea.setText(emp.getPost());
				teamArea.setText(emp.getTeam());
				projectArea.setText(emp.getProject());
				dateArea.setText(emp.getBirthdate());
			} else {

			}

		}
		
	}
	
	public boolean checkNumber(String text) {
		if(text.matches("^[0-9]*$")) {
			return true;
		}
		return false;
	}

}
