package chapter2_linked_lists;
/*
* KthElement - Return Kth Element
*/
import java.util.Scanner;

class KthElementToLast extends SinglyLinkedList{
  public static void main(String[] args){
    SinglyLinkedList sll = new SinglyLinkedList();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter no. of Elements : ");
    int t = sc.nextInt();
    System.out.println("Enter " + t +" Elements : ");
    while(t-- > 0){
      sll.appendToTail(sc.nextInt());
    }
    System.out.println("Enter k : ");
    int k = sc.nextInt();
    System.out.println("List : ");
    sll.print();
    System.out.println("Kth Element  = " + returnKthElementtoLast(sll.head, k));
    sc.close();
  }
  public static int returnKthElementtoLast(Node head, int k){
    Node n1 = head;
    Node n2 = head;
    if(n1 == null){
      System.out.println("List is Empty");
      return -1;
    }

    while(n1 != null && k-- != 0){
      n1 = n1.next;
    }

    if(k != 0){
      System.out.println("k out of index");
      return -1;
    }

    while(n1 != null && n2 != null){
      n1 = n1.next;
      n2 = n2.next;
    }

    return n2.data;
  }
}
