/*
* Graph - basic graph
*/
import java.util.*;

class Graph {
	private Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(); // Adjacency List

	//adds vertex
	public void createVertex(Integer v)
	{
		map.put(v, new LinkedList<Integer>());
	}

	// adds edge
	public void createEdge(Integer srcV, Integer destV)
	{
		if (!map.containsKey(srcV)){
      createVertex(srcV);
    }

		if (!map.containsKey(destV)){
      createVertex(destV);
    }

		map.get(srcV).add(destV);
	}

  //prints adjacency list
	public void print()
	{
		for (Integer v : map.keySet()) {
      System.out.print(v + ": ");
			for (Integer n : map.get(v)) {
        System.out.print(n + " ");
			}
			System.out.print("\n");
		}
	}

  public static void main(String args[])
	{
		Graph g = new Graph();
		g.createEdge(0, 1);
    g.createEdge(0, 6);
    g.createEdge(1, 2);
    g.createEdge(2, 3);
    g.createEdge(3, 1);
		g.createEdge(2, 5);
		System.out.println("Graph: ");
    g.print();
	}
}
