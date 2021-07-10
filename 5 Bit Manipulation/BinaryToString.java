/*
* BinaryToString - convert real number between 0 to 1 to its binary representation
*/
import java.util.*;
class BinaryToString{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number between 0 and 1");
    Double d = sc.nextDouble();
    if(d > 1 || d < 0){
      System.out.println("Not between 0 and 1 - ERROR");
      return;
    }
    System.out.println(getBinaryString(d));
  }
  private static String getBinaryString(Double d){
    int c = 32;
    String s = "";
    while(c != 0 && d != 0){
      d = d*2;
      if(d >= 1){
        s = s + 1;
        d = d - 1;
      }
      else{
        s = s + 0;
      }
      c--;
    }

    if(c == 0 && d != 0){
      return "ERROR";
    }

    return s;
  }
}
