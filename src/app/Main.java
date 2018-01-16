package app;

import javax.swing.JFrame;

import app.Interface.HomeInt;
import app.Interface.Intf;
import app.databases.SQLiteConnection;

public class Main {

	public static void main(String args[]) {
		

		final JFrame frame = new JFrame();
		final SQLiteConnection con = new SQLiteConnection();
		con.createDatabase();
		
		final Intf intf = new HomeInt(frame);
		intf.setInterface();
	}
}
