/*
* CommonAncestor - common ancestor of given 2 nodes
*/
import java.util.*;

class CommonAncestor extends MinimalTree{
  public static void main(String[] args)
	{
    //Sample Tree
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(2);//duplicate value
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n8 = new Node(8);//doesn't exist in tree

    /*
              1
            /   \
          2     3
        /   \    \
      4     5    7
            \
            6
    */
    n1.left = n2;
    n2.parent  = n1;
    n1.right = n3;
    n3.parent = n1;
    n3.right = n7;
    n7.parent = n3;
    n2.left = n4;
    n4.parent = n2;
    n2.right = n5;
    n5.parent = n2;
    n5.left = n6;
    n6.parent = n5;

    //testcase#1
    Node commonAncestor = commonAncestor(n4, n6);
    if(commonAncestor != null)
      System.out.println(commonAncestor.data);
    else{
      System.out.println("common ancestor doesn't exist");
    }

    //for duplicate check
    commonAncestor = commonAncestor(n4, n7);
    if(commonAncestor != null)
      System.out.println(commonAncestor.data);
    else{
      System.out.println("common ancestor doesn't exist");
    }

    //No common ancestor scenario
    commonAncestor = commonAncestor(n8, n3);
    if(commonAncestor != null)
      System.out.println(commonAncestor.data);
    else{
      System.out.println("common ancestor doesn't exist");
    }

	}

  private static Node commonAncestor(Node n1, Node n2){
    Node commonAncestor = null;

    List<Node> n1List = new ArrayList<Node>();
    while(n1 != null){
      n1List.add(n1);
      n1 = n1.parent;
    }

    while(n2 != null){
      if(n1List.contains(n2)){
        commonAncestor = n2;
        break;
      }
      n2 = n2.parent;
    }

    return commonAncestor;
  }

}
