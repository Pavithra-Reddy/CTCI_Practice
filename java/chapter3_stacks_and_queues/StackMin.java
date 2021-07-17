package chapter3_stacks_and_queues;
import java.util.*;
class StackMin extends Stack{
  private static Stack<Integer> minSt = new Stack<Integer>();
  private static Stack<Integer> st = new Stack<Integer>();

  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.println("Menu\n1. Push\n2. Pop\n3. Print Stack\n4. Get Minimum Element\n5. End");
      while(true){
        try{
          System.out.println("Enter option : ");
          int op = sc.nextInt();
          switch(op){
            case 1: System.out.println("Enter data");
                    push(sc.nextInt());
                    break;
            case 2: System.out.println(popElement() + " removed.");
                    break;
            case 3: st.print();
                    break;
            case 4: System.out.println("Min element: " + minSt.peek());
                    break;
            case 5: return;
            default: break;
          }
        }
        catch(Exception e){
          System.out.println("Stack is empty");
        }
      }
  }

  private static void push(int data){
    try{
      if(minSt.peek() >= data){
        minSt.push(data);
      }
    }
    catch(Exception e){
      minSt.push(data);
    }

    st.push(data);
  }

  private static int popElement() throws EmptyStackException {
    try{
      if(minSt.peek() == st.peek()){
        minSt.pop();
      }
      return st.pop();
    }
    catch(Exception e){
      throw new EmptyStackException();
    }

  }

}
