/*
* SinglyLinkedList - Basic Singly LinkedList Operations
*/

import java.util.*;

class SinglyLinkedList {
  Node head;
  Node tail;

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
      this.head = end; //if only one node exist
    }
    if(this.tail != null){
      this.tail.next = end;
    }
    this.tail = end;
  }

  void add(int d){
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
    if(this.tail == null){
      this.tail = this.head; //if only one node exist
    }
  }

  void delete(int d){
    Node n = this.head;
    if(n.data == d){
      if(this.head == this.tail){
        //one element exist;
        this.tail = null;
      }
      this.head = head.next;
    }
    while(n.next != null){
      if(n.next.data == d){
        if(n.next == this.tail){
          this.tail = n;
        }
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
