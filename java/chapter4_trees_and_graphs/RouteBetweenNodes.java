package chapter4_trees_and_graphs;
/*
* RouteBetweenNodes - checks if route exist between nodes or not - Using BFS
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class RouteBetweenNodes extends Graph<Integer>{
  public static void main(String[] args)
	{
		Graph<Integer> g = new Graph<Integer>();
		g.createEdge(1, 2);
    g.createEdge(1, 6);
    g.createEdge(2, 3);
    g.createEdge(3, 4);
    g.createEdge(4, 2);
		g.createEdge(3, 5);
    System.out.println(isRouteExist(g, 1, 4));
    System.out.println(isRouteExist(g, 4, 5));
    System.out.println(isRouteExist(g, 4, 1));
	}

  public static boolean isRouteExist(Graph<Integer> g, int src, int dest){
    List<Integer> visited = new ArrayList<Integer>();
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(src);
    visited.add(src);

    while(!queue.isEmpty()){
      List<Integer> adjacentNodes = g.getAdjacentNodes(queue.poll());
      for(int i : adjacentNodes){
        if(i == dest){
          return true;
        }
        if(!visited.contains(i)){
          visited.add(i);
          queue.add(i);
        }

      }
    }
    return false;
  }

}
