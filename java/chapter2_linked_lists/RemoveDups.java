package chapter2_linked_lists;
/*
* RemoveDups - Removes Duplicates from linked list
*/
import java.util.HashSet;
import java.util.Scanner;

class RemoveDups extends SinglyLinkedList{
  public static void main(String[] args){
    SinglyLinkedList sll = new SinglyLinkedList();
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0){
      sll.appendToTail(sc.nextInt());
    }
    System.out.println("Before : ");
    sll.print();
    //removeDuplicatesWithHashSet(sll.head);
    System.out.println("After : ");
    removeDuplicatesWithoutBuffer(sll.head);
    sll.print();
    sc.close();
  }
  public static void removeDuplicatesWithHashSet(Node head){
    Node n = head;
    if(n == null){
      System.out.println("List is Empty");
      return;
    }
    HashSet<Integer> hs = new HashSet<Integer>();
    hs.add(n.data);
    while(n.next != null){
      if(hs.contains(n.next.data)){
        n.next = n.next.next;
      }
      else{
        hs.add(n.next.data);
        n = n.next;
      }
    }
  }

  public static void removeDuplicatesWithoutBuffer(Node head){
    Node n = head;
    if(n == null){
      System.out.println("List is Empty");
      return;
    }
    while(n != null){
      removeNode(n);
      n = n.next;
    }
  }

  private static void removeNode(Node newHead){
    int data = newHead.data;
    while(newHead.next != null){
      if(newHead.next.data == data){
        newHead.next = newHead.next.next;
      }
      else{
        newHead = newHead.next;
      }
    }
  }
}
