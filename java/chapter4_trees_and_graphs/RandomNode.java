package chapter4_trees_and_graphs;
/*
* RandomNode - gives random node from a tree
*/
import java.util.*;
class Tree {
  Node root;

  class Node {
  	int data;
  	Node left, right;
  	int size = 0;

  	public Node(int data) {
      this.data = data;
			this.left = null;
			this.right = null;
			this.size = 1;
  	}

    public int getSize() {
  		return size;
  	}

  	public void insert(int d) {
      //if value is less than current node insert on left else right
  		if (d <= data) {
  			if (left == null) {
  				left = new Node(d);
  			} else {
  				left.insert(d);
  			}
  		} else {
  			if (right == null) {
  				right = new Node(d);
  			} else {
  				right.insert(d);
  			}
  		}
      //to count children of curent node
  		size++;
  	}

  	public Node getIthNode(int i) {
  		int leftSize = left == null ? 0 : left.getSize();
  		if (i < leftSize) {
  			return left.getIthNode(i);
  		} else if (i == leftSize) {
  			return this;
  		} else {
  			return right.getIthNode(i - (leftSize + 1));
  		}
  	}
  }

  public void insert(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			root.insert(data);
		}
	}

	public Node getRandomNode() {
		if (root == null)
      return null;

		Random random = new Random();
		int i = random.nextInt(root.getSize());
		return root.getIthNode(i);
	}

}

class RandomNode {

	public static void main(String[] args) {
    Tree t = new Tree();
    int[] array = {4, 3, 7, 2, 1, 5, 6, 8, 9, 10};
    for (int x : array) {
      t.insert(x);
    }
    System.out.println(t.getRandomNode().data);
    System.out.println(t.getRandomNode().data);
    System.out.println(t.getRandomNode().data);
    System.out.println(t.getRandomNode().data);
    System.out.println(t.getRandomNode().data);
    System.out.println(t.getRandomNode().data);
	}

}
