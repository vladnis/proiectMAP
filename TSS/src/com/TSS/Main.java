package com.TSS;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void test1() {
		ArrayList<Edge> edges = new ArrayList<Edge>(
				Arrays.asList(
					new Edge(0, 1),
					new Edge(0, 2),
					new Edge(0, 3),
					new Edge(1, 4),
					new Edge(2, 4, 0),
					new Edge(2, 5),
					new Edge(2, 6),
					new Edge(3, 6)
				)
			);
			
			ArrayList<Node> nodes = new ArrayList<Node>(
				Arrays.asList(
					new Node(0, 2),
					new Node(1, 3),
					new Node(2, 2),
					new Node(3, 1),
					new Node(4, 4),
					new Node(5, 5),
					new Node(6, 3)
				)
			);
			
			Graph graph = new Graph(nodes, edges);

			Scheduler scheduler = new Scheduler(graph);
			
			Integer numProcesors = 4;
			ArrayList<Processor> processorList = new ArrayList<Processor>();
			
			for (Integer i = 0; i < numProcesors; i++) {
				Processor p = new Processor(i, scheduler);
				p.start();
				processorList.add(p);
			}
			
			for (Processor p : processorList) {
				try {
					p.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
	
	public static void test2() {
		ArrayList<Edge> edges = new ArrayList<Edge>(
				Arrays.asList(
					new Edge(0, 3, 0),
					new Edge(1, 3),
					new Edge(1, 4),
					new Edge(1, 5),
					new Edge(3, 6, 0),
					new Edge(4, 7, 0),
					new Edge(5, 7),
					new Edge(7, 8)
				)
			);
			
			ArrayList<Node> nodes = new ArrayList<Node>(
				Arrays.asList(
					new Node(0, 2),
					new Node(1, 3),
					new Node(2, 2),
					new Node(3, 1),
					new Node(4, 4),
					new Node(5, 5),
					new Node(6, 3),
					new Node(7, 4),
					new Node(8, 5)
				)
			);
			
			Graph graph = new Graph(nodes, edges);

			Scheduler scheduler = new Scheduler(graph);
			
			Integer numProcesors = 3;
			ArrayList<Processor> processorList = new ArrayList<Processor>();
			
			for (Integer i = 0; i < numProcesors; i++) {
				Processor p = new Processor(i, scheduler);
				p.start();
				processorList.add(p);
			}
			
			for (Processor p : processorList) {
				try {
					p.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		test2();
		System.out.println("All tasks completed; Shutting Down");
	}

}
