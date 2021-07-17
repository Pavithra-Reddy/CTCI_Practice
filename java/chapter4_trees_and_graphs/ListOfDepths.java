package chapter4_trees_and_graphs;
/*
* ListOfDepths - LinkedList for each level of tree
*/
import java.util.ArrayList;
import java.util.List;
public class ListOfDepths extends TreeCustom{

	public static void main(String args[])
	{
		TreeCustom t = new TreeCustom();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    t.root = t.createBinaryTree(arr, t.root, 0);
		List<List<Node>> depthLists = getDepthLevelLists(t.root);
    for(List<Node> depth: depthLists){
      for(Node depthNode: depth){
        System.out.print(depthNode.data + " ");
      }
      System.out.println();
    }
	}

  public static List<List<Node>> getDepthLevelLists(Node root){
      List<List<Node>> depthLists = new ArrayList<List<Node>>();
      List<Node> parent = new ArrayList<Node>();
      parent.add(root);
      while(!parent.isEmpty()){
        depthLists.add(parent);
        List<Node> children = new ArrayList<Node>();
        for(Node p : parent){
          if(p.left !=null){
            children.add(p.left);
          }
          if(p.right !=null){
            children.add(p.right);
          }
        }
        parent = children;
      }

      return depthLists;
  }
}
