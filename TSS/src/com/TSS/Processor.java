package com.TSS;

import java.lang.Thread;

public class Processor extends Thread {

	private Scheduler scheduler;
	private Node task;
	
	public int procID;
	
	public Processor(Scheduler sched){
	}
	
	public void run(){
		
		this.task = scheduler.getTask(this.procID);
		
		try{
			task.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("Processor "+procID+" finished task "+task.getId());
		scheduler.removeTask(task.getId());
	}
	
	public int getID(){
		
		return this.procID;
	}
}
