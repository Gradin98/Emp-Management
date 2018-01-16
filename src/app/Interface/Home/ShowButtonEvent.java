package app.Interface.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import app.Interface.HomeInt;
import app.databases.SQLiteConnection;

public class ShowButtonEvent extends HomeInt implements ActionListener {

	final private Object[] columns;

	public ShowButtonEvent(JFrame frame, Object[] columns) {
		super(frame);
		this.columns = columns;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final SQLiteConnection con = new SQLiteConnection();
		final Object[][] obj = con.getContentDb();
		final JTable table = new JTable(obj, columns);
		final JScrollPane pane = new JScrollPane(table);
		
		pane.setBounds(20, 150, 700, 200);
		frame.getContentPane().add(pane);
		
	}
	
	

}
