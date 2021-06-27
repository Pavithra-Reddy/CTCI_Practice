/*
* SumLists - Returns linked list by adding two linked lists
*/
import java.util.*;

class SumLists extends SinglyLinkedList{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter 1st List size and elements");
    int t = sc.nextInt();
    SinglyLinkedList sll1 = new SinglyLinkedList();
    while(t-- > 0){
      sll1.appendToTail(sc.nextInt());
    }

    System.out.println("Enter 2nd size and elements");
    t = sc.nextInt();
    SinglyLinkedList sll2 = new SinglyLinkedList();
    while(t-- > 0){
      sll2.appendToTail(sc.nextInt());
    }

    System.out.println("Lists before Summation");
    sll1.print();
    sll2.print();
    System.out.println("Summation Result (Reverse Order)");
    SinglyLinkedList sumList = addListsReverseOrder(sll1.head, sll2.head);
    sumList.print();

    System.out.println("Summation Result");

    //Appends 0's at beginning to make length same
    Node n1 = sll1.head;
    Node n2 = sll2.head;
    while(n1 != null && n2 != null){
      n1 = n1.next;
      n2 = n2.next;
    }
    while(n1 != null){
      sll2.appendToHead(0);
      n1 = n1.next;
    }
    while(n2 != null){
      sll1.appendToHead(0);
      n2 = n2.next;
    }

    sumList = addLists(sll1.head, sll2.head);
    sumList.print();

  }

  private static SinglyLinkedList addListsReverseOrder(Node head1, Node head2){
    SinglyLinkedList sll3 = new SinglyLinkedList();
    Node n1 = head1;
    Node n2 = head2;
    int carry = 0;
    int sum = 0;

    while(n1 != null && n2 != null){
      sum =  n1.data + n2.data + carry;
      carry = sum/10;
      sum = sum%10;
      sll3.appendToTail(sum);
      n1 = n1.next;
      n2 = n2.next;
    }

    while(n1 != null){
      sum = n1.data + carry;
      carry = sum/10;
      sum = sum%10;
      sll3.appendToTail(sum);
      n1 = n1.next;
    }

    while(n2 != null){
      sum = n2.data + carry;
      carry = sum/10;
      sum = sum%10;
      sll3.appendToTail(sum);
      n2 = n2.next;
    }

    if(carry != 0){
      sll3.appendToTail(carry);
    }

    return sll3;
  }


  private static SinglyLinkedList addLists(Node head1, Node head2){
    SinglyLinkedList sll3 = new SinglyLinkedList();
    Node n1 = head1;
    Node n2 = head2;
    int carry = 0;
    int sum = 0;

    sum = n1.data + n2.data + addListsRecursion(n1.next, n2.next, sll3);
    carry = sum/10;
    sum = sum%10;
    sll3.appendToHead(sum);

    if(carry != 0){
      sll3.appendToHead(carry);
    }
    return sll3;
  }


  private static int addListsRecursion(Node head1, Node head2, SinglyLinkedList sll3){
    Node n1 = head1;
    Node n2 = head2;
    int carry = 0;
    int sum = 0;
    if(n1 == null || n2 == null){
      return 0;
    }

    sum = n1.data + n2.data + addListsRecursion(n1.next, n2.next, sll3);
    carry = sum/10;
    sum = sum%10;
    sll3.appendToHead(sum);

    return carry;
  }


}
