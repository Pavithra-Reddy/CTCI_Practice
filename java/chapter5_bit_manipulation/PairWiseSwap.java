package chapter5_bit_manipulation;
/*
* PairWiseSwap - swaps each pair in binary representation
*/
import java.util.Scanner;
class PairWiseSwap{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int i = sc.nextInt();
    int res = swapPairs(i);
    System.out.println("original " + i + " => " + Integer.toBinaryString(i) + " swapped " + res + " => " +  Integer.toBinaryString(res));
    sc.close();
  }
  private static int swapPairs(int i){
    //mask1 = 10101010101 - for even bits - to clear bits
    //mask2 = 01010101010 - for odd bits - to clear bits
    //And operation and shift 1 - t0 swap its place
    return ((i & 0xAAAAAAAA) >> 1) | ((i & 0x55555555) << 1);
  }
}
