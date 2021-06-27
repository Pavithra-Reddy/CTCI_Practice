/*
* Palindrome - checks if linked list is palindrome or not
*/
import java.util.*;

class Palindrome extends SinglyLinkedList{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter List size and elements");
    int t = sc.nextInt();
    SinglyLinkedList sll = new SinglyLinkedList();
    while(t-- > 0){
      sll.appendToTail(sc.nextInt());
    }

    System.out.println(isPalindrome(sll));
  }

  private static boolean isPalindrome(SinglyLinkedList sll){
    SinglyLinkedList ll = new SinglyLinkedList();
    Node headNode = sll.head;
    if(headNode == null){
      // empty list
      return true;
    }
    Node tailNode = sll.head.next;
    if(tailNode == null){
      // has only one element
      return true;
    }

    while(tailNode.next != null){
      ll.appendToTail(tailNode.data);
      tailNode = tailNode.next;
    }

    if(tailNode.data == headNode.data && isPalindrome(ll)){
      return true;
    }

    return false;
  }
}
