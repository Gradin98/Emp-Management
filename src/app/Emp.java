package app;

/**
 * Clasa care salveaza toate datele din bazele de date intr-un obiect
 * 
 * @author Kocsis Lorand
 *
 */
public class Emp {
	
	final private String id;
	final private String name;
	final private String firstname;
	final private String salary;
	final private String post;
	final private String team;
	final private String project;
	final private String birthdate;
	
	
	public Emp(String id, String name, String firstname, String salary, String post, String team, String project,
			String birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.salary = salary;
		this.post = post;
		this.team = team;
		this.project = project;
		this.birthdate = birthdate;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getSalary() {
		return salary;
	}
	
	
	public String getPost() {
		return post;
	}
	
	public String getTeam() {
		return team;
	}
	
	public String getProject() {
		return project;
	}
	
	public String getBirthdate() {
		return birthdate;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", firstname=" + firstname + ", salary=" + salary + ", post=" + post
				+ ", team=" + team + ", project=" + project + ", birthdate=" + birthdate + "]";
	}
	
	

}
