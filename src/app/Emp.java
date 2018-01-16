package app;

public class Emp {
	
	private String id;
	private String name;
	private String firstname;
	private String salary;
	private String post;
	private String team;
	private String project;
	private String birthdate;
	
	
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
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getSalary() {
		return salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getPost() {
		return post;
	}
	
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		this.team = team;
	}
	
	public String getProject() {
		return project;
	}
	
	public void setProject(String project) {
		this.project = project;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", firstname=" + firstname + ", salary=" + salary + ", post=" + post
				+ ", team=" + team + ", project=" + project + ", birthdate=" + birthdate + "]";
	}
	
	

}
