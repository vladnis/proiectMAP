package com.TSS;

public class Node {

	private Integer executionCost = 0;
	private Integer id = 0;
	private Integer forcedProcessor = null;
	
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
		this.executionCost = id;
	}
	
	public Integer getExecutionCost() {
		return this.id;
	}
	
	public void setExecutionCost(int cost) {
		this.executionCost = cost;
	}
	
	public void execute() {
		try {
			Thread.sleep(this.executionCost);
		} catch (InterruptedException e) {
			System.out.println("Could not sleep ");
		}
	}

}
