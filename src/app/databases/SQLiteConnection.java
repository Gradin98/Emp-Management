package app.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.Emp;
import app.Logs;

/**
 * Clasa care permite conectarea cu Baze de date de tip SQLite
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

			Logs.setLog("Try to connect to database");

			c = DriverManager.getConnection("jdbc:sqlite:" + System.getenv("APPDATA") + "\\ProiectP3\\database.db");
			stmt = c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Functie care creeaza baza de date in caz ca nu exista
	 */
	public void createDatabase() {
		connect();
		try {

			Logs.setLog("Check if database is created");

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

	/**
	 * Functie care actualizeaza datele in baza de date in functie de id
	 * 
	 * @param id
	 * @param name
	 * @param firstname
	 * @param salary
	 * @param post
	 * @param team
	 * @param project
	 * @param birthdate
	 */
	public void updateContent(String id, String name, String firstname, String salary, String post, String team,
			String project, String birthdate) {
		connect();
		Logs.setLog("Try to update data in database");
		try {
			if (checkData(id) && checkData(name) && checkData(firstname) && checkData(salary) && checkData(post)
					&& checkData(team) && checkData(project) && checkData(birthdate)) {
				String sql = "UPDATE Emp SET name = '" + name + "', firstname = '" + firstname + "', salary = " + salary
						+ ", post = '" + post + "', team = '" + team + "', project = '" + project + "', birthdate = '"
						+ birthdate + "' WHERE id LIKE " + id;

				stmt.executeUpdate(sql);
				stmt.close();
				Logs.setLog("Data update succesfull");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Functie care insereaza date in baza de date
	 * 
	 * @param name
	 * @param firstname
	 * @param salary
	 * @param post
	 * @param team
	 * @param project
	 * @param birthdate
	 */
	public void setContent(String name, String firstname, String salary, String post, String team, String project,
			String birthdate) {
		connect();
		Logs.setLog("Try to insert data in database");
		try {

			if (checkData(name) && checkData(firstname) && checkData(salary) && checkData(post) && checkData(team)
					&& checkData(project) && checkData(birthdate)) {
				String sql = "INSERT INTO Emp (name,firstname,salary,post,team,project,birthdate)" + " VALUES('" + name
						+ "','" + firstname + "','" + salary + "','" + post + "','" + team + "','" + project + "','"
						+ birthdate + "')";

				stmt.executeUpdate(sql);
				stmt.close();
				Logs.setLog("Data inserted succesfull");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Functie care sterge date din baza de date in functie de id
	 * 
	 * @param id
	 */
	public void deleteEmp(String id) {

		connect();
		Logs.setLog("Try to delete row in database");
		try {

			if (!checkData(id))
				return;

			String sql = "DELETE FROM Emp WHERE id LIKE " + id;

			stmt.executeUpdate(sql);
			stmt.close();

			Logs.setLog("Data deleted succesfull");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Functie care obtine date din baza de date in functie de id
	 * 
	 * @param id
	 * @return un obiect de tip EMP in caz de gaseste, null in caz contrar
	 */

	public Emp getEmpByID(String id) {

		connect();

		Logs.setLog("Try to get row by ID");
		try {
			if (!checkData(id))
				return null;

			ResultSet result = stmt.executeQuery("SELECT * FROM Emp WHERE id LIKE " + id);

			while (result.next()) {
				Emp emp = new Emp(result.getString("id"), result.getString("name"), result.getString("firstname"),
						result.getString("salary"), result.getString("post"), result.getString("team"),
						result.getString("project"), result.getString("birthdate"));
				stmt.close();

				Logs.setLog("Data finded succesfully");
				return emp;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	/**
	 * Functie care obtine toate datele din bazele de date
	 * 
	 * @return un tablou bidimensional, null in caz contrars
	 */
	public Object[][] getContentDb() {
		connect();

		Logs.setLog("Try to get all rows from database");

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

			Logs.setLog("Data returned succesfully");

			return data;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * Verifica datele daca sunt diferite de ""
	 * 
	 * @param text
	 * @return true in caz ca sunt valide, false in caz contrar
	 */
	private boolean checkData(String text) {
		if (!text.equals("")) {
			return true;
		}
		return false;
	}

}
