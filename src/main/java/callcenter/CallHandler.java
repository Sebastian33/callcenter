package callcenter;


public class CallHandler implements Runnable {
	public int time;
	private AbstractEmployee owner;
	CallHandler(AbstractEmployee ae)
	{
		owner = ae;
	}
	public void run()
	{
		try {
			Thread.sleep(time*1000); // talking to a customer
		} catch (InterruptedException e) {
		}
		owner.busy = false;
	}
}
