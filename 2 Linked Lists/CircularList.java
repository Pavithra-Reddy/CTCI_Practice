/*
* CircularList - Returns intersection point of circular list
*/
import java.util.*;

class CircularList extends SinglyLinkedList{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter 1st List size and elements");
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
    System.out.println("some elements of circular list : ");
    in = sll.head;
    t = len+(len-k);
    while(t-- > 0){
      System.out.print(in.data + " ");
      in = in.next;
    }

  }
}
