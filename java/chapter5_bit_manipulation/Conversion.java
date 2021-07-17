package chapter5_bit_manipulation;
class Conversion{
  public static void main(String[] args){
    int m = 74;//1001010
    int n =  29;// 0011101
    System.out.println(countConvertionBits(m, n));//Expected - 5
  }
  private static int countConvertionBits(int m, int n){
    int x = m^n; //xor sets bit in position where m and n are different
    //for counting no of set bits from x
    int c = 0;
    while (x > 0) {
        x = x & (x - 1);
        c++;
    }
    return c;
  }
}
