package com.TSS;

import java.lang.Thread;

public class Processor extends Thread {

	private Scheduler scheduler;
	private Node task;
	
	public Integer procID;
	
	public Processor(Integer procID, Scheduler sched){
		this.scheduler = sched;
		this.procID = procID;
	}
	
	public void run(){
		System.out.println("Starting proccesor with id: " + this.procID);
		
		while (true){
			this.task = scheduler.getTask(this.procID);

			if (task == null) {
				System.out.println("Processor with id: " + this.procID + " is closing.");
				return;
			}

			System.out.println("Processor " + this.procID + " received task " + task.getId());
			
			try{
				task.execute();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			scheduler.removeTask(task.getId(), this.procID);
			
			System.out.println("Processor " + this.procID + " finished node " + task.getId());
		}
	}

	public int getID(){
		
		return this.procID;
	}
}
