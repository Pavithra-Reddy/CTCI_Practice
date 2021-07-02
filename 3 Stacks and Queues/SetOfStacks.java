/*
* SetOfStacks - if stack reaches max height then add to another stack
*/
import java.util.*;
class SetOfStacks extends Stack{

  private static ArrayList<Stack<Integer>> stList = new ArrayList<Stack<Integer>>();
  private static int max = 0;
  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Max height of stack");
      max = sc.nextInt();

      System.out.println("Menu\n1. Push\n2. Pop \n3. End");
      while(true){
        try{
          System.out.println("Enter option : ");
          int op = sc.nextInt();
          switch(op){
            case 1: System.out.println("Enter data");
                    pushToSet(sc.nextInt());
                    break;
            case 2: System.out.println(popFromSet() + " removed.");
                    break;
            case 3: return;
            default: break;
          }
        }
        catch(Exception e){
          System.out.println("Stack is empty");
        }
      }
  }

  private static int popFromSet() throws EmptyStackException{
    if(stList.isEmpty()){
      throw new EmptyStackException();
    }
    Stack<Integer> st = stList.get(stList.size()-1);
    int data = st.pop();
    //System.out.println("**************** ele no." + currStLen + " stack no."+ stList.size());
    if(st.getSize() == 0){
      stList.remove(stList.size()-1);
    }
    return data;
  }

  private static void pushToSet(int data) throws EmptyStackException{
      Stack<Integer> st = new Stack<Integer>();
      if(stList.isEmpty() || stList.get(stList.size()-1).getSize() == max){
        stList.add(st);
      } else {
        st = stList.get(stList.size()-1);
      }
      st.push(data);
      //System.out.println("################### ele no." + currStLen + " stack no."+ stList.size());
  }

}
