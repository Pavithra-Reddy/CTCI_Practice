package chapter8_recursion_and_dp;

public class RecursiveMultiply {
	
	public static void main(String[] args) {
		System.out.println(multiply(12,32));
	}
	
	//Russian peasant multiplication
	public static int multiply(int a, int b) {
		if (a < b) 
			return multiply(b, a);
		
		int prod = 0;
		while (a > 0) {
			if ((a % 10) % 2 == 1) {
				prod = prod + b;
			}
			a = a >> 1;
			b = b << 1;
		}	
		return prod;
	}

}
