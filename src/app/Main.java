package app;

import javax.swing.JFrame;

import app.Interface.HomeInt;
import app.Interface.Intf;
import app.databases.SQLiteConnection;

/**
 * 
 * Clasa Main, care porneste aplicatia
 * 
 * @author Kocsis Lorand
 *
 */
public class Main {

	public static void main(String args[]) {
		
		Logs.setLog("Start app");

		final JFrame frame = new JFrame();
		final SQLiteConnection con = new SQLiteConnection();
		
		con.createDatabase();
		
		final Intf intf = new HomeInt(frame);
		intf.setInterface();
	}
}
