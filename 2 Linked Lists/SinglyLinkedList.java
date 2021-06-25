/*
* SinglyLinkedList - Basic Singly LinkedList Operations
*/

import java.util.*;

class SinglyLinkedList {
  Node head;

   class Node{
    int data;
    Node next = null;

    public Node(int d){
      this.data = d;
    }
  }

  void appendToTail(int d){
    Node end = new Node(d);
    if(this.head == null){
      this.head = end;
      return;
    }

    Node n = this.head;
    while(n.next != null){
      n= n.next;
    }
    n.next = end;
  }

  void appendToHead(int d){
    Node newHead = new Node(d);
    newHead.next = this.head;
    this.head = newHead;
  }

  void delete(int d){
    Node n = this.head;
    if(n.data == d){
      this.head = head.next;
    }
    while(n.next != null){
      if(n.next.data == d){
        n.next = n.next.next;
        return;
      }
      n = n.next;
    }
  }

  void print(){
    Node n = this.head;
    if(n == null){
      System.out.println("List is empty");
      return;
    }
    while(n != null){
      System.out.print(n.data + " ");
      n = n.next;
    }
    System.out.println();
  }
}
