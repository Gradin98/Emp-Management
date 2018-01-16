package app.Interface.Manage;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import app.Emp;
import app.Interface.ManageIntf;
import app.databases.SQLiteConnection;

public class SearchButtonEvent extends ManageIntf implements ActionListener {

	private JTextField nameArea;
	private JTextField searchArea;
	private JTextField firstNameArea;
	private JTextField salarArea;
	private JTextField postArea;
	private JTextField teamArea;
	private JTextField projectArea;
	private JTextField dateArea;

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

		if (searchArea.getText() != "") {
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

}
