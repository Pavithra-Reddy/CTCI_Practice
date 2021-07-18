package chapter8_recursion_and_dp;

public class Multiply {
	public static void main(String args[]) {
		System.out.println(multiply(123,24));
	}
	
	private static int multiply(int bigNum, int smallNum) {
		if(smallNum == 0)
			return 0;
		if(smallNum == 1)
			return bigNum;
		
		int h = smallNum>>1;
		
		int half = multiply(h, bigNum);
		
		if(smallNum%2 == 0) {
			return half+half;
		} else {
			return half+half+bigNum;
		}
		
	}
}
