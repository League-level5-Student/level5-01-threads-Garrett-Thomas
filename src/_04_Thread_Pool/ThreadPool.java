package _04_Thread_Pool;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread[] ts;
	ConcurrentLinkedQueue<Task> clq = new ConcurrentLinkedQueue<Task>();

	public ThreadPool(int i) {
		ts = new Thread[i];
		for (int j = 0; j < i; j++) {
			ts[j]= new Thread(new Worker(clq));
		}
		// TODO Auto-generated constructor stub
	}
	public void addTask(Task t) {
		clq.add(t);
	}
	public void start() {
		for (int i = 0; i < ts.length; i++) {
			ts[i].start();
			
		}
		for (int i = 0; i < ts.length; i++) {
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
