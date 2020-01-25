package callcenter;

public class Manager extends AbstractEmployee{
	private static Manager manager = null;
	private Manager()
	{
		super();
		message="Manager handles the call ";
	}
	
	public static Manager getInstance()
	{
		if(manager == null)
		{
			manager = new Manager();
		}
		return  manager;
	}
}
