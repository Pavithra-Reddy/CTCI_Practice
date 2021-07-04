/*
* Minimal Tree - binary search tree with minimum height using sorted array
*/
class MinimalTree extends Tree{
  public static void main(String args[])
	{
		Tree t = new Tree();
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		t.root = createBinarySearchTree(arr, 0, arr.length-1);
    System.out.print("Inorder Traversal: ");
		t.inOrder(t.root);
    System.out.print("\nPreOrder Traversal: ");
		t.preOrder(t.root);
    System.out.print("\nPostOrder Traversal: ");
		t.postOrder(t.root);
	}

  public static Node createBinarySearchTree(int[] arr, int begin, int end) {
    if (begin > end) {
        return null;
    }
    int mid = (begin+end)/2;
    Node root = new Node(arr[mid]);
    root.left = createBinarySearchTree(arr, begin, mid-1);
    root.right = createBinarySearchTree(arr, mid+1,end);
    return root;
	}

}
