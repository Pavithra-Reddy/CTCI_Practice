package chapter2_linked_lists;
/*
* Intersection - Returns intersection point
*/
import java.util.Scanner;

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

    System.out.println("Enter intersection point(0 based)");
    t = sc.nextInt();
    sc.close();
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


    Node intersectedNode = findIntersection(sll1.head, sll2.head);
    if(intersectedNode == null){
      System.out.println("No Intersection");
      return;
    }
    System.out.println("Intersected at " + intersectedNode.data);

    //No intersection case
    System.out.println("Enter List size and elements for without intersection scenario");
    t = sc.nextInt();
    SinglyLinkedList sll3 = new SinglyLinkedList();
    while(t-- > 0){
      sll3.appendToTail(sc.nextInt());
    }

    intersectedNode = findIntersection(sll1.head, sll3.head);
    if(intersectedNode == null){
      System.out.println("No Intersection");
      return;
    }
    System.out.println("Intersected at " + intersectedNode.data);

  }

  private static Node findIntersection(Node head1, Node head2){
    int len1 = 0;
    int len2 = 0;
    Node n1 = head1;
    Node n2 = head2;

    while(n1 != null){
      n1 = n1.next;
      len1++;
    }

    while(n2 != null){
      n2 = n2.next;
      len2++;
    }

    n1 = head1;
    n2 = head2;

    if(len1 < len2){
      int k = len2 - len1;
      while(k-- > 0){
        n2 = n2.next;
      }
    }
    else{
      int k = len1 - len2;
      while(k-- > 0){
        n1 = n1.next;
      }
    }

    while(n1 != n2){
      n1 = n1.next;
      n2 = n2.next;
    }

    return n1;
  }


}
