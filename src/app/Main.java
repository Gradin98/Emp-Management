package app;

import javax.swing.JFrame;

import app.Interface.HomeInt;
import app.Interface.Intf;
import app.databases.SQLiteConnection;

public class Main {

	public static void main(String args[]) {
		

		JFrame frame = new JFrame();
		SQLiteConnection con = new SQLiteConnection();
		con.createDatabase();
		
		Intf intf = new HomeInt(frame);
		intf.setInterface();
	}
}
