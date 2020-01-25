package callcenter;

import java.util.Random;

public abstract class AbstractEmployee{
	private static final int avgTime = 6; //average duration of a call
	protected CallHandler ch;
	protected boolean busy;
	protected String message;
	protected Random gen;
	
	public AbstractEmployee()
	{
		ch = new CallHandler(this);
		busy = false;
		gen = new Random(System.currentTimeMillis());
	}
	
	public boolean isBusy()
	{
		return busy;
	}
	
	/* number - call number*/
	public void handleCall(int number) throws InterruptedException
	{
		busy = true;
		ch.time = (int)Math.abs(gen.nextGaussian()) + avgTime; 
		System.out.println(message + number);
		Thread t = new Thread(ch);
		t.start();
	}
}
