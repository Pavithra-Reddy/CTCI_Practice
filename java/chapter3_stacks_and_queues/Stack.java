package chapter3_stacks_and_queues;
/*
* Stack - LIFO Datastructure - Basic implementation
*/
class Stack<T>{
  private StackNode<T> top;
  private int size;

  private static class StackNode<T>{
    private T data;
    private StackNode<T> next;
    public StackNode(T data){
      this.data = data;
    }
  }

  void push(T data){
    StackNode<T> newNode = new StackNode<T>(data);
    newNode.next = top;
    top = newNode;
    this.size++;
  }

  T pop() throws EmptyStackException{
    if(top == null){
      //System.out.println("Stack is Empty");
      throw new EmptyStackException();
      //return null;
    }
    T data = top.data;
    top = top.next;
    this.size--;
    return data;
  }

  T peek() throws EmptyStackException{
    if(top == null){
      //System.out.println("Stack is Empty");
      throw new EmptyStackException();
      //return null;
    }
    return top.data;
  }

  boolean isEmpty(){
    return top == null;
  }

  void print(){
    StackNode<T> node = top;
    if(node == null){
      System.out.println("Stack is empty");
    }
    else{
      while(node != null){
        System.out.print(node.data + " ");
        node = node.next;
      }
      System.out.println();
    }
  }

  int getSize(){
    return this.size;
  }
}

class EmptyStackException extends Exception{

}
