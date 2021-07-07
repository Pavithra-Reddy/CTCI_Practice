/*
* PathWithSum - returns countof paths whose sum is equal to given value
*/
import java.util.*;

class PathWithSum extends MinimalTree{

  private static List<Integer> pathList = new ArrayList<Integer>();
  private static int totalCount = 0;
  public static void main(String[] args)
	{
    int arr[] = { 1, 2, 3, 2, 1, -1, 4};
    Tree t = new Tree();
		t.root = t.createBinaryTree(arr, t.root, 0);

    int k = 3;
    countPathWithSum(t.root,k);
    System.out.println(totalCount);
	}

  private static void countPathWithSum(Node root, int k){
  	 if (root == null)
  		return;

     //dfs traversal
     pathList.add(root.data);
     countPathWithSum(root.left, k);
     countPathWithSum(root.right, k);

     //to get path which contains current Node(moving up)
  	int currSum = 0;
    int currInd = pathList.size() - 1;
  	for (int i = currInd; i >= 0; i--) {
  		currSum = currSum + pathList.get(i);
  		if (currSum == k)
  			totalCount++;
  	}

    //removing currentNode as moving to its parent
    pathList.remove(currInd);
  }

}
