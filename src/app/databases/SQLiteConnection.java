package app.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.Emp;

/**
 * Clasa care permite conectarea cu Baze de date de tip SQLite
 * 
 * <ol>
 * Contine functiile:
 * <li>{@link #checkConnection()}</li>
 * <li>{@link #connect()}</li>
 * <li>{@link #openConnection()}</li>
 * <li>{@link #createDatabase()}</li>
 * <li>{@link #setContent(String, String)}</li>
 * <li>{@link #contentList(String)}</li>
 * <li>{@link #contentByDate(String, String, String)}</li>
 * <li>{@link #numeClasa()}</li>
 * </ol>
 * 
 * @author Kocsis Lorand
 *
 */

public class SQLiteConnection {

	Connection c = null;
	Statement stmt = null;

	/**
	 * Functie care se conecteaza la baza de date sqlite locala
	 */
	public void connect() {
		try {
			c = DriverManager.getConnection("jdbc:sqlite:" + System.getenv("APPDATA") + "\\ProiectP3\\database.db");
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createDatabase() {
		connect();
		try {
			Class.forName("org.sqlite.JDBC");

			String sql = "CREATE TABLE IF NOT EXISTS `Emp` (\r\n" + "	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,\r\n"
					+ "	`name`	TEXT NOT NULL,\r\n" + "	`firstname`	TEXT NOT NULL,\r\n"
					+ "	`salary`	INTEGER NOT NULL,\r\n" + "	`post`	TEXT NOT NULL,\r\n"
					+ "	`team`	TEXT NOT NULL,\r\n" + "	`project`	TEXT NOT NULL,\r\n" + "	`birthdate`	DATE\r\n" + ")";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}

	public void updateContent(String id, String name, String firstname, String salary, String post, String team,
			String project, String birthdate) {
		connect();
		try {
			if (checkData(id) && checkData(name) && checkData(firstname) && checkData(salary) && checkData(post)
					&& checkData(team) && checkData(project) && checkData(birthdate)) {
				String sql = "UPDATE Emp SET name = '" + name + "', firstname = '" + firstname + "', salary = " + salary
						+ ", post = '" + post + "', team = '" + team + "', project = '" + project + "', birthdate = '"
						+ birthdate + "' WHERE id LIKE " + id;

				stmt.executeUpdate(sql);
				stmt.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setContent(String name, String firstname, String salary, String post, String team, String project,
			String birthdate) {
		connect();
		try {

			if (checkData(name) && checkData(firstname) && checkData(salary) && checkData(post) && checkData(team)
					&& checkData(project) && checkData(birthdate)) {
				String sql = "INSERT INTO Emp (name,firstname,salary,post,team,project,birthdate)" + " VALUES('" + name
						+ "','" + firstname + "','" + salary + "','" + post + "','" + team + "','" + project + "','"
						+ birthdate + "')";

				stmt.executeUpdate(sql);
				stmt.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteEmp(String id) {

		connect();
		try {

			if (!checkData(id))
				return;

			String sql = "DELETE FROM Emp WHERE id LIKE " + id;

			stmt.executeUpdate(sql);
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Emp getEmpByID(String id) {

		connect();

		try {
			if (!checkData(id))
				return null;

			ResultSet result = stmt.executeQuery("SELECT * FROM Emp WHERE id LIKE " + id);

			while (result.next()) {
				Emp emp = new Emp(result.getString("id"), result.getString("name"), result.getString("firstname"),
						result.getString("salary"), result.getString("post"), result.getString("team"),
						result.getString("project"), result.getString("birthdate"));
				stmt.close();
				return emp;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public Object[][] getContentDb() {
		connect();
		try {

			ResultSet result = stmt.executeQuery("SELECT * FROM Emp;");

			ArrayList<Emp> lista = new ArrayList<Emp>();
			//

			while (result.next()) {
				lista.add(new Emp(result.getString("id"), result.getString("name"), result.getString("firstname"),
						result.getString("salary"), result.getString("post"), result.getString("team"),
						result.getString("project"), result.getString("birthdate")));

			}

			Object[][] data = new Object[lista.size()][8];

			int i = 0;
			for (Emp e : lista) {
				Object[] row = new Object[8];

				row[0] = e.getId();
				row[1] = e.getName();
				row[2] = e.getFirstname();
				row[3] = e.getSalary();
				row[4] = e.getPost();
				row[5] = e.getTeam();
				row[6] = e.getProject();
				row[7] = e.getBirthdate();

				data[i] = row;
				i++;

			}
			stmt.close();

			return data;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private boolean checkData(String text) {
		if (!text.equals("")) {
			return true;
		}
		return false;
	}

}
