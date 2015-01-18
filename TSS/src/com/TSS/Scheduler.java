package com.TSS;

import java.util.ArrayList;

public class Scheduler {

	public Graph graph;
	
	public ArrayList<Processor> processorList = new ArrayList<Processor>();
	
	public Scheduler(Graph g){
	
		this.graph = g;
	}
	
	
	synchronized public Node getTask(int procID){
		
		Node task;
		
		if (graph.getNrTasks() == 0){
			System.out.println("All tasks completed; Shutting Down");
			notifyAll();
			return null;
		}
		
		task = graph.findUnboundedTask(procID);
		
		while (task == null) {
		
			task = graph.findUnboundedTask(procID);
		}

		System.out.println("Selected task for execution: " + task.getId() + " exec: " + task.isInExecution());
		
		return task;
	}
	
	synchronized public void removeTask(int taskID,int procID){
		graph.deleteNode(taskID, procID);
	}
}