package app.Interface.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import app.Interface.HomeInt;
import app.databases.SQLiteConnection;

public class ShowButtonEvent extends HomeInt implements ActionListener {

	private Object[] columns;

	public ShowButtonEvent(JFrame frame, Object[] columns) {
		super(frame);
		this.columns = columns;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SQLiteConnection con = new SQLiteConnection();
		Object[][] obj = con.getContentDb();
		JTable table = new JTable(obj, columns);
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(20, 150, 700, 200);
		frame.getContentPane().add(pane);
		
	}
	
	

}
