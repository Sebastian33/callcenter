package callcenter;


public class CallCenter {
	private AbstractEmployee[] staff;
	
	public CallCenter(int staffNum)
	{
		staff = new AbstractEmployee[staffNum + 2]; // employees + supervisor + manager  
		for(int i = 0; i < staffNum; i++)
		{
			staff[i] = new Employee(i);
		}
		staff[staffNum] = Supervisor.getInstance();
		staff[staffNum + 1] = Manager.getInstance();
	}

	public AbstractEmployee findCallHandler()
	{
		while(true)
		{
			for(int i = 0; i < staff.length; i++)
			{
				if(!staff[i].isBusy())
				{
					return staff[i];
				}
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
		}
	}
}
