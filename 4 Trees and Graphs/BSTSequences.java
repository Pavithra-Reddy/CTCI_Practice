/*
* BSTSequences - gets sequences which will result in same bst
* explanation reference - https://medium.com/@jackwootton/binary-search-tree-sequences-53163b1f374a
*/

import java.util.*;

class BSTSequences extends MinimalTree{

  public static void main(String[] args)
  {

    int arr[] = { 1, 2, 3, 4, 5, 6};
    Tree t = new Tree();
    t.root = createBinarySearchTree(arr, 0, arr.length-1);

    /*
            3
          /   \
        1     5
      /      / \
    2       4   6

    */

    List<List<Integer>> bstSeq = getBSTSequences(t.root);
    for(List<Integer> ls : bstSeq){
      for(Integer i : ls){
        System.out.print(i + " ");
      }
      System.out.println();
    }

  }

  private static List<List<Integer>> getBSTSequences(Node root) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();


      if (root == null) {
          //For leaf nodes, no child sequence will be returned
          res.add(new ArrayList<Integer>());
          return res;
      }

      List<List<Integer>> ls  = getBSTSequences(root.left);
      List<List<Integer>> rs = getBSTSequences(root.right);

      List<Integer> temp = new ArrayList<Integer>();
      temp.add(root.data);

      //merge lists to get different sequences
      for (List<Integer> list1 : ls) {
          for (List<Integer> list2 : rs) {
              getSequencesByJoining(list1, list2, res, temp);
          }
      }

      return res;
  }

  private static void getSequencesByJoining(List<Integer> list1, List<Integer> list2,
          List<List<Integer>> res, List<Integer> temp) {

      if (list1.isEmpty() || list2.isEmpty()) {
        List<Integer> temp2 = new ArrayList<Integer>(temp);
        temp2.addAll(list1);
        temp2.addAll(list2);
        res.add(temp2);
        return;
      }

      int data = list1.get(0);
      list1.remove(0);
      temp.add(data);
      getSequencesByJoining(list1, list2, res, temp);
      temp.remove(temp.size() - 1);
      list1.add(0, data);

      data = list2.get(0);
      list2.remove(0);
      temp.add(data);
      getSequencesByJoining(list1, list2, res, temp);
      temp.remove(temp.size() - 1);
      list2.add(0, data);
   }
}
