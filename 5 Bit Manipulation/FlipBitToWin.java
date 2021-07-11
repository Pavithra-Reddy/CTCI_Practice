/*
* FlipBitToWin - Flip one bit to get longest sequences of 1
*/
import java.util.*;
class FlipBitToWin{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int count = getLongestSequenceCount(n);
    System.out.println("original " + Integer.toBinaryString(n) + " count = " + count);
  }
  private static int getLongestSequenceCount(int n){
    int max = 0;
    int c1 = 0;
    while((n&1) == 1){
      n = n >> 1;
      c1++;
    }
    max = c1;
    while( n != 0){
      int c2 = 0;
      n = n>>1;
      while((n&1) == 1){
        n = n>>1;
        c2++;
      }
      if(max < (c1+c2)){
        max = c1+c2;
      }
      c1 = c2;
    }

    return max + 1;
  }
}
