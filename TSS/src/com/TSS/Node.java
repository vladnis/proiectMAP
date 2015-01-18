package com.TSS;

public class Node {

	private Integer executionCost = 0;
	private Integer id = 0;
	private Integer forcedProcessor = null;
	
	public int getForcedProcessor() {
		return this.forcedProcessor;
	}
	
	public void setForcedProcessor(Integer forcedProcessor) {
		this.forcedProcessor = forcedProcessor;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.executionCost = id;
	}
	
	public int getExecutionCost() {
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
