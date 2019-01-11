package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	ConcurrentLinkedQueue<Task> cla = new ConcurrentLinkedQueue<Task>();

	public Worker(ConcurrentLinkedQueue<Task> taskQueue) {
		cla = taskQueue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!cla.isEmpty()) {
			cla.poll().perform();
		}
	}

}
