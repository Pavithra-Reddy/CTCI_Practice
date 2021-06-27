/*
* LoopDetection - Returns Starting point of circular list
*/
import java.util.*;

class LoopDetection extends SinglyLinkedList{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Circular List size and elements");
    int t = sc.nextInt();
    int len = t;
    SinglyLinkedList sll = new SinglyLinkedList();
    while(t-- > 0){
      sll.appendToTail(sc.nextInt());
    }

    System.out.println("Enter intersection point(0 based)");
    t = sc.nextInt();
    int k = t;

    if(t<0 || t >= len-1){
      System.out.println("Out of Bounds");
      return;
    }


    Node fn = sll.head;
    while(fn.next != null){
      fn = fn.next;
    }

    Node in = sll.head;
    while(t-- > 0){
      in = in.next;
    }

    fn.next = in;
    /*System.out.println("some elements of circular list : ");
    in = sll.head;
    t = len+(len-k);
    while(t-- > 0){
      System.out.print(in.data + " ");
      in = in.next;
    }*/

    System.out.println("Enter no. of Elements for normal list: ");
    t = sc.nextInt();
    System.out.println("Enter " + t +" Elements : ");
    SinglyLinkedList nll = new SinglyLinkedList();
    while(t-- > 0){
      nll.appendToTail(sc.nextInt());
    }

    //Circular List
    Node loopStartingNode = findLoopStartingNode(sll.head);
    if(loopStartingNode == null){
      System.out.println("Loop Doesn't exist");
      return;
    }
    System.out.println("Loop Starting Node = " + loopStartingNode.data);

    //Normal List
    loopStartingNode = findLoopStartingNode(nll.head);
    if(loopStartingNode == null){
      System.out.println("Loop Doesn't exist");
      return;
    }
    System.out.println("Loop Starting Node. = " + loopStartingNode.data);

  }

  private static Node findLoopStartingNode(Node head){
    Node n1 = head;//slow pointer
    Node n2 = head;//fast pointer

    while(n1 != null && n2 != null && n2.next != null){
      n1 = n1.next;
      n2 = n2.next.next;
      if(n1 == n2)
        break;
    }
    if(n1 == null || n2 == null || n2.next == null){
      //Loop Doesn't exist
      return null;
    }

    n1 = head;
    while(n1 != n2){
      n1 = n1.next;
      n2 = n2.next;
    }

    return n1;

  }
}
