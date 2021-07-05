/*
* Successor - Prints next element in inorder sequence
*/
class Successor extends MinimalTree{
  public static void main(String args[])
	{
    int arr[] = { 1,2,3,5,6,7,8,10,14,15,17};
		Tree bst = new Tree();
		bst.root = createBinarySearchTree(arr, 0, arr.length-1);
    System.out.print("InorderTraversal: ");
		bst.inOrder(bst.root);
    System.out.println();
    System.out.println("input: " + bst.root.right.data);
    Node res =getSuccessor(bst.root.right);
    System.out.println(res != null ? res.data :null);

    System.out.println("input: " + bst.root.left.data);
    res =getSuccessor(bst.root.left);
    System.out.println(res != null ? res.data :null);

    System.out.println("input: " + bst.root.data);
    res =getSuccessor(bst.root);
    System.out.println(res != null ? res.data :null);
	}

  public static Node getSuccessor(Node root){
    Node parent = root.parent;
    if(parent == null || root.right != null){
      root = root.right;
  		while (root.left != null) {
  			root = root.left;
  		}
  		return root;
    } else {
      if(parent!=null && parent.left != root){
        root = parent;
        parent = parent.parent;
      }
      if(parent == null){
        return null;
      }
      return parent;
    }
  }

}
