package chapter2_linked_lists;
/*
* Partition - Partitions list based on x such that elements less than x will be on left side of x
*/
import java.util.Scanner;

class Partition extends SinglyLinkedList{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter List size and elements");
    int t = sc.nextInt();
    SinglyLinkedList sll = new SinglyLinkedList();
    while(t-- > 0){
      sll.appendToTail(sc.nextInt());
    }
    System.out.println("Enter element to be partitioned");
    int x = sc.nextInt();

    System.out.println("Before : ");
    sll.print();
    SinglyLinkedList partitionedList = paritionList(sll, x);
    System.out.println("After : ");
    partitionedList.print();
    sc.close();
  }

  private static SinglyLinkedList paritionList(SinglyLinkedList sll, int x){
    SinglyLinkedList partitionedList = new SinglyLinkedList();
    Node n = sll.head;

    while(n != null){
      if(n.data < x){
        partitionedList.appendToHead(n.data);
      }
      else{
        partitionedList.appendToTail(n.data);
      }
      n = n.next;
    }

    return partitionedList;
  }
}
