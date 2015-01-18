package com.TSS;

import java.util.List;

public class Scheduler {

	public Graph graph;
	
	public List<Processor> processorList;
	
	public scheduler(Graph g){
	
		this.graph = g;
	}
	
	
	public Node getTask(int procID){
		
		Node task;
		
		if (graph.getNrTasks() == 0){
			System.out.println("All tasks completed; Shutting Down");
			notifyAll();
		}
		while ( task = graph.findUnboundedTask(procID) == null);
		
		return task;
	}
	
	public void removeTask(int taskID){
		graph.deleteNode(taskID);
	}
}