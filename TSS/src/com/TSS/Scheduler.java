package com.TSS;

import java.util.ArrayList;

public class Scheduler {

	public Graph graph;
	
	public ArrayList<Processor> processorList = new ArrayList<Processor>();
	
	public Scheduler(Graph g){
	
		this.graph = g;
	}
	
	
	synchronized public Node getTask(int procID){
		
		if (graph.getNrTasks() == 0){
			System.out.println("All tasks completed; Shutting Down");
			this.notifyAll();
			return null;
		}
		
		Node task = graph.findUnboundedTask(procID);

		while (task == null) {
			try {
				System.out.println("Waiting: " + procID);
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (graph.getNrTasks() == 0) {
				return null;
			}

			task = graph.findUnboundedTask(procID);
		}

		return task;
	}
	
	synchronized public void removeTask(int taskID,int procID){
		graph.deleteNode(taskID, procID);
		this.notify();
	}
}