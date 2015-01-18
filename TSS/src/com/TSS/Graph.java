package com.TSS;

import java.util.List;

public class Graph {

	public List<Node> nodeList;
	public List<Edge> edgeList;
	
	public void deleteNode(int nodeId, int procID){
		
		for(Node n : nodeList){
			if (n.getId() == nodeId){
				
				//Find coressponding edges
				for( Edge e : edgeList){
					if(e.from == nodeId){
						// Find child Nodes
						if (e.communicationCost == 0){
							for(Node cn : nodeList){
								if(cn.getId() == e.to){
									cn.setForcedProcessor(procID);
								}
							}
						}
						//Delete Edge
						edgeList.remove(e);
					}
				}
				//Remove Node
				nodeList.remove(n);
			}
		}
	}
	
	public Node findUnboundedTask(int procID){
		
		for(Node n : nodeList){
			
		}
		
		return null;
	}
}
