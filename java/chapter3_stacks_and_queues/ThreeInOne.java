package chapter3_stacks_and_queues;
/*
* ThreeInOne - Three Stacks using one array -- only for positive integers
*/
import java.util.*;
class ThreeInOne{

  private static int arr[];
  private static int arrInd = 0;
  private static int topElements[];
  private static int prevElements[];

  public static void push(int stNum, int data){
    arrInd++;
    if(arrInd == arr.length){
      System.out.println("Array is Full");
      return;
    }
    arr[arrInd] = data;
    prevElements[arrInd] = topElements[stNum];
    topElements[stNum] = arrInd;
  }

  public static int pop(int stNum) throws Exception{
    if(arrInd == 0 || topElements[stNum] == -1){
      throw new Exception();
    }
    int data = arr[topElements[stNum]];
    topElements[stNum] = prevElements[topElements[stNum]];
    arrInd--;
    return data;
  }

  public static int peek(int stNum) throws Exception{
    if(arrInd == 0 || topElements[stNum] == -1){
      throw new Exception();
    }
    return arr[topElements[stNum]];
  }

  public static void print(int stNum){
    int top = topElements[stNum];
    while(top != -1){
      System.out.println(arr[top]);
      top = prevElements[top];
    }
  }

  public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Max length of array");
      initializeArrays(sc.nextInt(), 3);
      System.out.println("Menu\n1. Push\n2. Pop \n3. Peek \n4. Print\n5. End");
      while(true){
        try{
          System.out.println("Enter operation : ");
          int stNum;
          int op = sc.nextInt();
          switch(op){
            case 1: System.out.println("Enter Stack O based: ");
                    stNum = sc.nextInt();
                    System.out.println("Enter data");
                    push(stNum, sc.nextInt());
                    break;
            case 2: System.out.println("Enter Stack Number(0 based): ");
                    stNum = sc.nextInt();
                    System.out.println(pop(stNum) + " removed.");
                    break;
            case 3: System.out.println("Enter Stack Number(0 based): ");
                    stNum = sc.nextInt();
                    System.out.println(peek(stNum));
                    break;
            case 4: System.out.println("Enter Stack Number(0 based): ");
                    stNum = sc.nextInt();
                    print(stNum);
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

  private static void initializeArrays(int arrLen, int numOfStack){
    arr = new int[arrLen];
    prevElements = new int[arrLen];
    topElements = new int[numOfStack];

    for(int i = 0; i < arrLen; i++){
      prevElements[i] = -1;
    }

    for(int i = 0; i < numOfStack; i++){
      topElements[i] = -1;
    }

  }
}
