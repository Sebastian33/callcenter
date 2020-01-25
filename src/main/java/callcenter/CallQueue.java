package callcenter;

import java.util.Random;
import java.util.LinkedList;
import java.util.Queue;
public class CallQueue implements Runnable{
	private int custNum;
	private Random gen;
	private static final int newCallAvgTime = 1000; // average time between two calls, milliseconds
	private Queue<Integer> calls = new LinkedList<Integer>();
	
	public CallQueue(int custNum0)
	{
		custNum = custNum0;
		gen = new Random(System.currentTimeMillis());
	}
	
	public void run()
	{
		for(int i = 0; i < custNum; i++)
		{
			try {
				Thread.sleep((int)(Math.abs(gen.nextGaussian())*1000) + newCallAvgTime);
			} catch (InterruptedException e) {
			}
			
			synchronized(calls)
			{
				calls.offer(i);
			}
		}
	}
	
	public int getCall()
	{
		Integer res;
		synchronized(calls)
		{
			res = calls.poll();
		}
		return res == null ? -1 : res.intValue();
	}
}
