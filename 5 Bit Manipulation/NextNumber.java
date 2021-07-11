/*
* NextValue - prints next smallest and next biggest value with same number of ones
*/
import java.util.*;
class NextNumber{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nextBiggest = getNextBiggestValue(n);
    int nextSmallest = getNextSmallestValue(n);
    System.out.println("original " + Integer.toBinaryString(n) + " nextBiggest " + Integer.toBinaryString(nextBiggest) + " nextSmallest " + Integer.toBinaryString(nextSmallest));
  }
  private static int getNextBiggestValue(int n){
    int c = n;//Suppose n = 1100001100
    int c0 = 0;
    int c1 = 0;
    //System.out.println(Integer.toBinaryString(c));
    //Moves index from trailing 0s
    // breaks at c0 = 2  & c = 11000011
    while (((c & 1) == 0) && (c != 0)) {
        c0++;
        c >>= 1;
    }
    //System.out.println(c0 + " " + Integer.toBinaryString(c));

    //Moves index from trailing 1s after 0s
    //breaks at c1 = 2 & c = 110000
    while ((c & 1) == 1) {
        c1++;
        c >>= 1;
    }
    //System.out.println(c1 + " " + Integer.toBinaryString(c));

    //value doesn't exist
    if (c0 + c1 == 31 || c0 + c1 == 0)
      return -1;

    // p = 4
    int p = c0 + c1;
    //System.out.println(p);

    //Adds 1 at p position
    //1100001100 | 000010000 -> 1100011100
    n = n | (1 << p);
    //System.out.println(Integer.toBinaryString(n));

    //Clears bits right side of p
    //1100011100 & 1111110000 - > 1100010000
    n = n & ~((1 << p) - 1);
    //System.out.println(Integer.toBinaryString(n));

    //c1-1 1s will be added at beginning of n
    //1100010000 | 0000000001 - > 1100010001
    n = n | (1 << (c1 - 1)) - 1;
    //System.out.println(Integer.toBinaryString(n));

    return n;
  }
  private static int getNextSmallestValue(int n){
    int c = n;
    int c0 = 0;
    int c1 = 0;
    int p = 0;

    while((c & 1) == 1){
      c1++;
      c = c >> 1;
    }

    //value doesn't exist
    if(c == 0)
      return -1;

    while((c&1) == 0 && c != 0){
      c = c >> 1;
      c0++;
    }

    p = c0 + c1;;
    //System.out.println(p);

    //System.out.println(Integer.toBinaryString(n));
    n = n & ((~0) << (p+1));
    //System.out.println(Integer.toBinaryString(n));
    n = n | ((1 << (c1 + 1)) - 1) << (c0 - 1);
    //System.out.println(Integer.toBinaryString(n));

    return n;
  }
}
