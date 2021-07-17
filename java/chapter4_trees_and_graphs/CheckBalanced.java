package chapter4_trees_and_graphs;
/*
* Check Balanced - check if given tree is balanced or not
*/
class CheckBalanced extends MinimalTree{
  public static void main(String args[])
	{
    //balanced tree
	  	TreeCustom t = new TreeCustom();
		int arr[] = { 0, 1, 2, 3, 4};
		t.root = createBinarySearchTree(arr, 0, arr.length-1);
    System.out.println(checkBalance(t.root));

    //Unbalanced tree
    TreeCustom t2 = new TreeCustom();
    int arr2[] = { 0, 1, 2};
    t2.root = createBinarySearchTree(arr2, 0, arr2.length-1);
    t2.root.left = t.root;
    System.out.println(checkBalance(t2.root));
	}

  public static boolean checkBalance(Node root){
    if(root == null){
      return true;
    }
    if(getHeight(root) != -1){
      return true;
    }
    return false;
  }

  private static int getHeight(Node root){
    if(root == null){
      return -1;
    }
    int leftSubtreeHeight = getHeight(root.left);
    int rightSubtreeHeight = getHeight(root.right);
    if(Math.abs(leftSubtreeHeight-rightSubtreeHeight) > 1){
      return -1;
    } else{
      return Math.max(leftSubtreeHeight,rightSubtreeHeight)+1;
    }
  }

}
