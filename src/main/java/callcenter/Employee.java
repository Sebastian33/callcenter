package callcenter;


public class Employee extends AbstractEmployee {
	private int id;
	
	public Employee(int id0)
	{
		super();
		id = id0;
		message = "Employee" + getId() + " handles the call ";
	}

	public int getId() {
		return id;
	}
}
