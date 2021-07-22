package chapter17_hard;

public class AddWithoutPlus {

	public static void main(String[] args) {
		int a = 16;
		int b = 12;
		System.out.println(add(a,b));
	}

	private static int add(int a, int b) {
		if(b == 0)
			return a;
		int sum = a^b;
		int carry = (a&b) << 1;
		return add(sum,carry);
	}

}
