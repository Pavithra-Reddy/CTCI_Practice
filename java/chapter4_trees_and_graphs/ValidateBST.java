package chapter4_trees_and_graphs;
/*
* ValidateBST - validates if it is binary search tree or not
*/
class ValidateBST extends MinimalTree{
  public static void main(String args[])
	{
    int arr[] = { 0, 1, 2, 3, 4, 5,6};

    //binary search tree
    TreeCustom bst = new TreeCustom();
		bst.root = createBinarySearchTree(arr, 0, arr.length-1);
    System.out.println(validateBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

    //binary tree
    TreeCustom bt = new TreeCustom();
    bt.root = bt.createBinaryTree(arr, bt.root, 0);
    System.out.println(validateBST(bt.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

  public static boolean validateBST(Node root, int min, int max){
    if(root == null){
      return true;
    }

    if (!isBetweenRange(root.data, min, max)) {
			return false;
		}
		if (!validateBST(root.left, min, root.data) || !validateBST(root.right, root.data, max)) {
			return false;
		}

    return true;
  }

  public static boolean isBetweenRange(int data, int min, int max){
    return min <= data && data < max;
  }

}
