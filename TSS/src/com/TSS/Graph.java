package com.TSS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Graph {

	public ArrayList<Node> nodeList;
	public ArrayList<Edge> edgeList;
	
	public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges) {
		this.nodeList = new ArrayList<Node>(nodes);
		this.edgeList = new ArrayList<Edge>(edges);
	}

	public void addNodes(List<Node> nodes) {
		for (Node node : nodes) {
			nodeList.add(node);
		}
	}
	
	public void addEdges(List<Edge> edges) {
		for (Edge edge : edges) {
			edgeList.add(edge);
		}
	}
	
	 synchronized public void deleteNode(int nodeId, int procID){
		
		for(Iterator<Node> iterator = this.nodeList.iterator(); iterator.hasNext();) {
			Node n = iterator.next();
			//Remove Node
			
			if (n.getId() != nodeId){
				continue;
			}

			iterator.remove();
				
			//Find corresponding edges
			for(Iterator<Edge> it2 = this.edgeList.iterator(); it2.hasNext();) {
				Edge e = it2.next();
				
				if(e.getFrom() != nodeId){
					continue;
				}
				
				//Delete Edge
				it2.remove();
				
				// Find child Nodes
				if (e.getCommunicationCost() == null) {
					continue;
				}
				
				if (e.getCommunicationCost() != null && e.getCommunicationCost() == 0){
					for(Node cn : nodeList){
						if(cn.getId() == e.getTo()){
							cn.setForcedProcessor(procID);
						}
					}
				}
			}
		}
	}
	
	synchronized public Node findUnboundedTask(int procID){
		
		for(Node n : nodeList) {
			boolean bounded = false;

			if( (n.getForcedProcessor() == null || 
				n.getForcedProcessor() == procID) &&
				!n.isInExecution()) {

				for( Edge e : edgeList) {
					if( e.getTo() == n.getId()){
						bounded = true;
					}
				}
				if (!bounded){
					n.setExecution();
					return n;
				}
			}
		}
		System.out.println("No node available for: " + procID);
		
		return null;
	}
	
	public Integer getNrTasks() {
		return nodeList.size();
	}
}
