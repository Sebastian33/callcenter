package callcenter;


public class Supervisor extends AbstractEmployee{
	private static Supervisor supervisor = null;
	private Supervisor()
	{
		super();
		message="Superviser handles the call ";
	}
	
	public static Supervisor getInstance()
	{
		if(supervisor == null)
		{
			supervisor = new Supervisor();
		}
		return  supervisor;
	}
}
