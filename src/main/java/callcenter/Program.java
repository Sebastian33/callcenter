package callcenter;


public class Program {
	private static final int empnum = 3;
	private static final int customers = 50;
	public static void demonstration() throws InterruptedException
	{
		CallCenter callCenter = new CallCenter(empnum);
		CallQueue callQueue = new CallQueue(customers);
		AbstractEmployee freeOp;
		
		int currentCall;
		Thread workday = new Thread(callQueue);
		workday.start();
		for(int i = 0; i < customers; i++)
		{
			//waiting for a new call
			currentCall = callQueue.getCall();
			while(currentCall < 0);
			{
				Thread.sleep(100);
				currentCall = callQueue.getCall();
			}
			
			//finding free operator and handle the call
			freeOp = callCenter.findCallHandler();
			freeOp.handleCall(currentCall);
		}
	}
	
	public static boolean findCallHandler_commonEmployeeTest()
	{
		CallCenter callCenter = new CallCenter(2);
		AbstractEmployee common = callCenter.findCallHandler();
		if(!Employee.class.isInstance(common))
		{
			System.out.println("not an instance of Employee");
			return false;
		}
		
		if(((Employee)common).getId() != 0)
		{
			System.out.println("wrong id");
			return false;
		}
		return true;
	}
	
	public static boolean findCallHandler_commonEmployeeTest2()
	{
		CallCenter callCenter = new CallCenter(2);
		AbstractEmployee common = callCenter.findCallHandler();
		try {
			common.handleCall(0);
		} catch (InterruptedException e) {
		}
		//first operator is busy now
		common = callCenter.findCallHandler();
		if(!Employee.class.isInstance(common))
		{
			System.out.println("not an instance of Employee");
			return false;
		}
		
		if(((Employee)common).getId() != 1)
		{
			System.out.println("wrong id");
			return false;
		}
		return true;
	}
	
	public static boolean findCallHandler_supervisorTest()
	{
		CallCenter callCenter = new CallCenter(1);
		AbstractEmployee operator = callCenter.findCallHandler();
		try {
			operator.handleCall(0);
		} catch (InterruptedException e) {
		}
		//common operator is busy now
		operator = callCenter.findCallHandler();
		if(!Supervisor.class.isInstance(operator))
		{
			System.out.println("not an instance of Supervisor");
			return false;
		}
		return true;
	}
	
	public static boolean findCallHandler_managerTest()
	{
		CallCenter callCenter = new CallCenter(0);
		AbstractEmployee operator = callCenter.findCallHandler();
		try {
			operator.handleCall(0);
		} catch (InterruptedException e) {
		}
		//supervisor is busy now
		operator = callCenter.findCallHandler();
		if(!Manager.class.isInstance(operator))
		{
			System.out.println("not an instance of Manager");
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println(findCallHandler_commonEmployeeTest());
		System.out.println(findCallHandler_commonEmployeeTest2());
		System.out.println(findCallHandler_supervisorTest());
		System.out.println(findCallHandler_managerTest());
		//demonstration();
	}
}