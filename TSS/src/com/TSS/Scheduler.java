package com.TSS;

import java.util.List;

public class Scheduler {

	public Graph graph;
	
	public List<Processor> processorList;
	
	public Scheduler(Graph g){
	
		this.graph = g;
	}
	
	
	public Node getTask(int procID){
		
		Node task;
		
		if (graph.getNrTasks() == 0){
			System.out.println("All tasks completed; Shutting Down");
			notifyAll();
			return null;
		}
		task = graph.findUnboundedTask(procID);
		if (task == null){
			try{
				this.wait();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return task;
	}
	
	public void removeTask(int taskID){
		graph.deleteNode(taskID);
	}
}