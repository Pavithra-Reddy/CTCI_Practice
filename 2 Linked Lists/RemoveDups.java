/*
* RemoveDups - Removes Duplicates from linked list
*/
import java.util.*;

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
    removeDuplicatesWithHashSet(sll.head);
    System.out.println("After : ");
    sll.print();
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
}
