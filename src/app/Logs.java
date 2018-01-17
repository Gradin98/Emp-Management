package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * Clasa care se ocupa de logurile aplicatiei
 * 
 * @author Kocsis Lorand
 *
 */
public class Logs {

	public static void setLog(String message) {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		try (FileWriter fw = new FileWriter(System.getenv("APPDATA") + "\\ProiectP3\\logs.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(timestamp + " : " + message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
