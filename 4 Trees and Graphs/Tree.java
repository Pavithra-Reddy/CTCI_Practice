/*
* Tree - Basics
*/

public class Tree {
	Node root;

	static class Node {
		int data;
		Node left, right;
		Node parent;
		Node(int data)
		{
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = null;
		}
	}

	public Node createBinaryTree(int[] arr, Node root, int i)
	{
		if (i >= arr.length) {
		    return root;
		}

    Node temp = new Node(arr[i]);
    root = temp;
    root.left = createBinaryTree(arr, root.left, 2 * i + 1);
		if(root.left != null)
			root.left.parent = root;
    root.right = createBinaryTree(arr, root.right, 2 * i + 2);
		if(root.right != null)
			root.right.parent = root;
    return root;
	}

	public void preOrder(Node root)
	{
		if (root != null) {
			visit(root.data);
      preOrder(root.left);
			preOrder(root.right);
		}
	}

  public void inOrder(Node root)
	{
		if (root != null) {
			inOrder(root.left);
			visit(root.data);
			inOrder(root.right);
		}
	}

  public void postOrder(Node root)
	{
		if (root != null) {
      postOrder(root.left);
      postOrder(root.right);
			visit(root.data);
		}
	}

  public void visit(int data){
    System.out.print(data + " ");
  }
  /*
	public static void main(String args[])
	{
		Tree t = new Tree();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		t.root = t.createBinaryTree(arr, t.root, 0);
    System.out.print("Inorder Traversal: ");
		t.inOrder(t.root);
    System.out.print("\nPreOrder Traversal: ");
		t.preOrder(t.root);
    System.out.print("\nPostOrder Traversal: ");
		t.postOrder(t.root);
	}*/
}
