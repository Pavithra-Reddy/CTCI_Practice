/*
* Intersection - Returns intersection point
*/
import java.util.*;

class Intersection extends SinglyLinkedList{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter 1st List size and elements");
    int t = sc.nextInt();
    SinglyLinkedList sll1 = new SinglyLinkedList();
    while(t-- > 0){
      sll1.appendToTail(sc.nextInt());
    }

    System.out.println("Enter 2nd List before intersection");
    t = sc.nextInt();
    SinglyLinkedList sll2 = new SinglyLinkedList();
    while(t-- > 0){
      sll2.appendToTail(sc.nextInt());
    }

    System.out.println("Enter intersection point");
    t = sc.nextInt();

    Node ln = sll2.head;
    while(ln.next != null){
      ln = ln.next;
    }

    Node fn = sll1.head;
    while(t-- > 0 && fn != null){
      fn = fn.next;
    }
    if(fn == null){
      if(t == 0){
        System.out.println("intersected at last index");
      }
      else{
        System.out.println("no intersection (out of bound)");
      }
      return;
    }
    ln.next = fn;
    System.out.println("First List");
    sll1.print();
    System.out.println("Second List");
    sll2.print();
  }
}
