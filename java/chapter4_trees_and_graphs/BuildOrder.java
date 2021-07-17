package chapter4_trees_and_graphs;
/*
* BuildOrder - returns build order based on dependancy
*/
import java.util.*;

class BuildOrder extends Graph<Character>{
  public static void main(String[] args)
	{
		Graph<Character> g = new Graph<Character>();

		g.createEdge('a', 'f');
    g.createEdge('b', 'f');
    g.createEdge('c', 'd');
    g.createEdge('d', 'a');
    g.createEdge('d', 'b');
		g.createVertex('e');

    printOrder(g);

    g.createEdge('f', 'c');

    printOrder(g);

    g = new Graph<Character>();
    g.createEdge('a', 'f');
    g.createEdge('a', 'b');
    g.createEdge('a', 'c');
    g.createEdge('b', 'f');
    g.createEdge('c', 'f');
    g.createVertex('d');
    g.createEdge('e', 'a');
    g.createEdge('e', 'b');
    g.createVertex('f');
    g.createEdge('g', 'd');

    printOrder(g);
	}

  public static void printOrder(Graph<Character> g){
    List<Character> result = new ArrayList<Character>();
     Map<Character, List<Character>> adjList = g.getAdjacencyList();
     Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
     int total = adjList.size();
     for(Map.Entry<Character, List<Character>> e: adjList.entrySet()){
       map.put(e.getKey(), new ArrayList<Character>(e.getValue()));
       if(e.getValue().isEmpty()){
         result.add(e.getKey());
         total--;
       }
     }

     if(result.isEmpty()){
       System.out.println("Cycle detected. No Valid Build Order Found.");
       return;
     }


     while(total != 0){
       int prevTotal = total;
       for(Map.Entry<Character, List<Character>> e: map.entrySet()){
         if(e.getValue().isEmpty()){
           continue;
         }
         e.getValue().removeAll(result);
         if(e.getValue().isEmpty()){
           result.add(e.getKey());
           total--;
         }
       }
       if(total == prevTotal){
         System.out.println("Cycle detected. No Valid Build Order Found.");
         return;
       }
     }

     for(Character ch : result){
       System.out.print(ch + " ");
     }
     System.out.println();
     return;
  }

}
