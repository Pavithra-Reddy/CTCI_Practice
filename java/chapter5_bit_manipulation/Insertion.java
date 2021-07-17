package chapter5_bit_manipulation;
class Insertion{
  public static void main(String[] args){
    int m = 9;//1001
    int n =  521;// 1000001001
    int i = 2;
    int j = 5;
    System.out.println(insert(m, n, i, j));//Expected - 1000100101 - 549
  }
  private static int insert(int m, int n, int i, int j){
    //For mask
    //~0 << (j+1) - 1s before j
    //((1<<i) - 1) - 1s after i
    int mask = ~0 << (j+1) | ((1<<i) - 1);
    //n & mask - clears bits
    // m << i - moves m to i bits which adds 0's at beginning and end of m for correct position
    return n & mask | m << i;
  }
}
