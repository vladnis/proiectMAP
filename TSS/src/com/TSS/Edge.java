package com.TSS;

public class Edge {

	private Integer From = null;
	private Integer To = null;
	private Integer communicationCost = null;
	
	public Edge(Integer From, Integer To) {
		this.setTo(To);
		this.setFrom(From);
	}
	
	public Edge(Integer From, Integer To, Integer communicationCost) {
		this.setTo(To);
		this.setFrom(From);
		this.setCommunicationCost(communicationCost);
	}
	
	public Integer getFrom() {
		return this.From;
	}
	
	public void setFrom(Integer nodeId) {
		this.From = nodeId;
	}
	
	public Integer getTo() {
		return this.To;
	}
	
	public void setTo(Integer nodeId) {
		this.To = nodeId;
	}
	
	public Integer getCommunicationCost() {
		return this.communicationCost;
	}
	
	public void setCommunicationCost(Integer communicationCost) {
		this.communicationCost = communicationCost;
	}

}
