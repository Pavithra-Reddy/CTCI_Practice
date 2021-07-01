/*
* Queue - FIFO DS
*/
class Queue<T>{
  private QueueNode<T> first;
  private QueueNode<T> last;

  private static class QueueNode<T>{
    private T data;
    private QueueNode<T> next;
    public QueueNode(T data){
      this.data = data;
    }
  }

  void push(T data){
    QueueNode<T> newNode = new QueueNode<T>(data);
    if(last == null){
      //list is empty
      last = newNode;
      first = newNode;
      return;
    }
    last.next = newNode;
    last = newNode;
  }

  T pop() throws EmptyQueueException{
    if(first == null){
      //System.out.println("Queue is Empty");
      throw new EmptyQueueException();
      //return null;
    }
    if(first == last){
      //Single element exist
      T data = first.data;
      first = null;
      last = null;
      return data;
    }
    T data = first.data;
    first = first.next;
    return data;
  }

  T peek() throws EmptyQueueException{
    if(first == null){
      //System.out.println("Queue is Empty");
      throw new EmptyQueueException();
      //return null;
    }
    return first.data;
  }

  boolean isEmpty(){
    return first == null;
  }

  void print(){
    QueueNode<T> node = first;
    if(node == null){
      System.out.println("Queue is empty");
    }
    else{
      while(node != null){
        System.out.print(node.data + " ");
        node = node.next;
      }
      System.out.println();
    }
  }
}

class EmptyQueueException extends Exception{

}
