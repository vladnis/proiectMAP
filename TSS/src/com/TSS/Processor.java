package com.TSS;

import java.lang.Thread;

public class Processor extends Thread {

	private Scheduler scheduler;
	private Node task;
	
	public int procID;
	
	public Processor(Scheduler sched){
	}
	
	public void run(){
		
		while (true){
			this.task = scheduler.getTask(this.procID);
			
			if (task == null){
				return;
			}
			
			try{
				task.execute();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println("Processor "+this.procID+" finished task "+task.getId());
			
			scheduler.removeTask(task.getId(), this.procID);
			scheduler.notify();
		}
	}
	
	public int getID(){
		
		return this.procID;
	}
}
