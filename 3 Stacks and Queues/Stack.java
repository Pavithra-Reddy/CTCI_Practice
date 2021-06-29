/*
* Stack - LIFO Datastructure - Basic implementation
*/
class Stack<T>{
  private StackNode<T> top;

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
  }

  T pop() throws EmptyStackException{
    if(top == null){
      //System.out.println("Stack is Empty");
      throw new EmptyStackException();
      //return null;
    }
    T data = top.data;
    top = top.next;
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
}

class EmptyStackException extends Exception{

}
