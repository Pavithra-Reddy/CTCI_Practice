/*
* Graph - basic graph
*/
import java.util.*;

class Graph<T> {
	private Map<T, List<T>> map = new HashMap<T, List<T>>(); // Adjacency List

	//adds vertex
	public void createVertex(T v)
	{
		map.put(v, new LinkedList<T>());
	}

	// adds edge
	public void createEdge(T srcV, T destV)
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
		for (T v : map.keySet()) {
      System.out.print(v + ": ");
			for (T n : map.get(v)) {
        System.out.print(n + " ");
			}
			System.out.print("\n");
		}
	}

	/*
  public static void main(String args[])
	{
		Graph<Integer> g = new Graph<Integer>();
		g.createEdge(0, 1);
    g.createEdge(0, 6);
    g.createEdge(1, 2);
    g.createEdge(2, 3);
    g.createEdge(3, 1);
		g.createEdge(2, 5);
		System.out.println("Graph: ");
    g.print();
	}
	*/
}
