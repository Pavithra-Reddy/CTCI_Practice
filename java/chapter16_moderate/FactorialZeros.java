package chapter16_moderate;

public class FactorialZeros {

	public static void main(String[] args) {
		int n =10;
		//System.out.println(fact(n));
		System.out.println(count(n));
	}
	
	private static int count(int n) {
		if (n < 0) {
			return 0;
		}
		
		int c = 0;
		int i = 5;
		while(n/i > 0) {
			c = c + (n/i);
			i = i * 5;
		}
		
		return c;
	}
	
	/*
	private static int fact(int n) {
		if (n == 1) {
			return 1;
		} 
		return n * fact(n - 1);
	}*/
}
