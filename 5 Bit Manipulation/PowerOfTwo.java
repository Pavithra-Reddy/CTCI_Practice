/*
* PowerOfTwo - (n & (n-1)) == 0 - checks power of two or not
*/
import java.util.*;
class PowerOfTwo{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(isPowerOfTwo(n));
  }
  private static boolean isPowerOfTwo(int n){
    return (n & (n-1)) == 0;
  }
}
