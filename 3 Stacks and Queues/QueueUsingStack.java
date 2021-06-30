import java.util.*;
class QueueUsingStack extends Stack{

  private static Stack<Integer> st1 = new Stack<Integer>();
  private static Stack<Integer> st2= new Stack<Integer>();

  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);

      System.out.println("Menu\n1. Push\n2. Pop\n3. Peek\n4. End");
      while(true){
        try{
          System.out.println("Enter option : ");
          int op = sc.nextInt();
          switch(op){
            case 1: System.out.println("Enter data");
                    st1.push(sc.nextInt());
                    break;
            case 2: System.out.println(popFromQueue() + " removed.");
                    break;
            case 3: System.out.println(peekQueue());
                    break;
            case 4: return;
            default: break;
          }
        }
        catch(Exception e){
          System.out.println("Stack is empty");
        }
      }
  }

  private static int popFromQueue() throws EmptyStackException{
    moveElementsToSecondStack();
    return st2.pop();
  }

  private static int peekQueue() throws EmptyStackException{
    moveElementsToSecondStack();
    return st2.peek();
  }

  private static void moveElementsToSecondStack(){
    try{
      int data = st2.peek();
    } catch(Exception e1){
      try{
        while(st1.peek() != null){
            st2.push(st1.pop());
        }
      }
      catch(Exception e2){
        //Stack 1 is empty
      }
    }
  }

}
