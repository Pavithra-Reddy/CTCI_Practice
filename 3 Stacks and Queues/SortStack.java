import java.util.*;
class SortStack extends Stack{

  private static Stack<Integer> st1 = new Stack<Integer>();
  private static Stack<Integer> st2= new Stack<Integer>();

  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);

      System.out.println("Menu\n1. Push\n2. Pop\n3. Peek\n4. Sort\n5. Print\n6. End");
      while(true){
        try{
          System.out.println("Enter option : ");
          int op = sc.nextInt();
          switch(op){
            case 1: System.out.println("Enter data");
                    st1.push(sc.nextInt());
                    break;
            case 2: System.out.println(st1.pop() + " removed.");
                    break;
            case 3: System.out.println(st1.peek());
                    break;
            case 4: sort();
                    break;
            case 5: st1.print();
                    break;
            case 6: return;
            default: break;
          }
        }
        catch(Exception e){
          System.out.println("Stack is empty");
        }
      }
  }

  private static void sort(){
    try{
      while(st1.peek() != null){

        int data = st1.pop();
        try{
          if(st2.peek() <= data){
            st2.push(data);
          }
          else{
            while(st2.peek() > data){
              st1.push(st2.pop());
            }
            st2.push(data);
          }
        }
        catch(Exception e1){
          st2.push(data);
        }

      }
    } catch(Exception e2){
      try{
        while(st2.peek() != null){
          st1.push(st2.pop());
        }
      }
      catch(Exception e3){

      }

    }
  }

}
