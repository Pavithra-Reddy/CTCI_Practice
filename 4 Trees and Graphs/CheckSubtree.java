/*
* CheckSubtree - checks is tree 1 is subtree of tree 2
*/
import java.util.*;

class CheckSubtree extends MinimalTree{
  public static void main(String[] args)
	{
    int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Tree t1 = new Tree();
		t1.root = t1.createBinaryTree(arr, t1.root, 0);

    int arr2[] = { 5, 10};
    Tree t2 = new Tree();
		t2.root = t2.createBinaryTree(arr2, t2.root, 0);

    int arr3[] = { 10, 5};
    Tree t3 = new Tree();
		t3.root = t3.createBinaryTree(arr3, t3.root, 0);

    // it is a subtree
    System.out.println(isSubtree(t1,t2));
    //not a subtree
    System.out.println(isSubtree(t1,t3));
	}

  private static boolean isSubtree(Tree t1, Tree t2){
    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();

    getPreOrderString(t1.root, s1);
    getPreOrderString(t2.root, s2);

    return (s1.toString().indexOf(s2.toString()) != -1);
  }
  private static void getPreOrderString(Node root, StringBuilder s)
	{
		if (root != null) {
      s.append(root.data);
      getPreOrderString(root.left, s);
			getPreOrderString(root.right, s);
		}
    else{
      s.append("*");
    }
	}

}
