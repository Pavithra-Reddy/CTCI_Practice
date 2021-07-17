package chapter2_linked_lists;
/*
* Delete Middle Node - Removes given node(not first/last) from linked list
*/
import java.util.Scanner;

class DeleteMiddleNode extends SinglyLinkedList{
  public static void main(String[] args){
    SinglyLinkedList sll = new SinglyLinkedList();
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int len = t;
    while(t-- > 0){
      sll.appendToTail(sc.nextInt());
    }
    System.out.println("Enter index of node to be deleted(0 based):");
    int k = sc.nextInt();
    sc.close();
    if(k == 0 || k >= len-1){
      System.out.println("Not a middle node");
      return;
    }
    Node middleNode = sll.head;
    while(k-- > 0){
      middleNode = middleNode.next;
    }
    System.out.println("Before : ");
    sll.print();
    middleNodeDelete(middleNode);
    System.out.println("After : ");
    sll.print();
  }

  private static void middleNodeDelete(Node middleNode){
    middleNode.data = middleNode.next.data;
    middleNode.next = middleNode.next.next;
  }
}
