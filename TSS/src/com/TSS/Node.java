package com.TSS;

public class Node {

	private Integer executionCost = 0;
	private Integer id = 0;
	private Integer forcedProcessor = null;
	private boolean inExecution = false;
	
	public Node(Integer nodeId, Integer executionCost) {
		this.setId(nodeId);
		this.setExecutionCost(executionCost);
	}
	
	public Integer getForcedProcessor() {
		return this.forcedProcessor;
	}
	
	public void setForcedProcessor(Integer forcedProcessor) {
		this.forcedProcessor = forcedProcessor;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getExecutionCost() {
		return this.executionCost;
	}
	
	public void setExecutionCost(int cost) {
		this.executionCost = cost;
	}
	
	public void setExecution(){
		this.inExecution = true;
	}
	
	public boolean isInExecution(){
		return this.inExecution;
	}
	
	public void execute() {
		try {
			Thread.sleep(this.executionCost * 1000);
		} catch (InterruptedException e) {
			System.out.println("Could not sleep");
		}
	}

}
