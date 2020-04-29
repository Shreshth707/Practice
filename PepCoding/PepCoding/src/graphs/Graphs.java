package graphs;

import java.util.ArrayList;
/*
 * Has Path (Graphs)
 * Print All Paths (Graphs)
 */

public class Graphs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		graph.add(new ArrayList<>()); // 0
		graph.add(new ArrayList<>());// 1
		graph.add(new ArrayList<>());// 2
		graph.add(new ArrayList<>());// 3
		graph.add(new ArrayList<>());// 4
		graph.add(new ArrayList<>());// 5
		graph.add(new ArrayList<>());// 6

		addEdge(0, 1, 10);
		addEdge(1, 2, 10);
		addEdge(2, 3, 10);
		addEdge(0, 3, 40);
		//addEdge(4, 3, 2);
		addEdge(5, 4, 3);
		addEdge(6, 5, 3);
		addEdge(6, 4, 8);

		// DisplayGraph();

		 boolean hasPath = HasPath(1, 6);
		System.out.println(hasPath);
		// PrintAllPaths(1,6,"");
	}

	static int[] nodes = new int[7];

	static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

	public static void PrintAllPaths(int src, int dst, String asf) {
		if (src == dst) {
			System.out.println(asf + Integer.toString(dst));
			return;
		}
		for (int i = 0; i < graph.get(src).size(); i++) {
			if (nodes[graph.get(src).get(i).nbr] != 1) {
				nodes[src] = 1;
				PrintAllPaths(graph.get(src).get(i).nbr, dst, asf + Integer.toString(src) + "->");
				nodes[src] = 0;
			}

		}
	}

	public static boolean HasPath(int src, int dst) {
		if (src == dst) {
			return true;
		}
		for (int i = 0; i < graph.get(src).size(); i++) {
			if (nodes[graph.get(src).get(i).nbr] != 1) {
				nodes[graph.get(src).get(i).nbr] = 1;
				boolean rans = HasPath(graph.get(src).get(i).nbr, dst);
				if (rans)
					return rans;
				nodes[graph.get(src).get(i).nbr] = 0;
			}

		}

		return false;

	}

	public static void DisplayGraph() {
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				System.out.print(graph.get(i).get(j).nbr + "-" + graph.get(i).get(j).wt + " ");
			}
			System.out.println();
		}
	}

	public static class Edge {
		int nbr;
		int wt;

		public Edge(int nbr, int wt) {
			this.nbr = nbr;
			this.wt = wt;
		}
	}

	public static void addEdge(int v1, int v2, int wt) {
		Edge e1 = new Edge(v2, wt);
		graph.get(v1).add(e1);
		Edge e2 = new Edge(v1, wt);
		graph.get(v2).add(e2);
	}

}
