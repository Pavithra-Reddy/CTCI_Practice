package chapter16_moderate;

public class ContiguousSequence {
	public static void main(String[] args) {
		int[] a = {1,5,6,-7,3,2,9,-19,2,3,3,3,3,3,6};
		System.out.println(getLargestSum(a));
	}
	
	private static int getLargestSum(int[] a) {
		int max = 0;
		int curr = 0;
		for (int i = 0; i < a.length; i++) {
			curr += a[i];
			if (max < curr) {
				max = curr;
			} else if (curr < 0) {
				curr = 0;
			}
		}
		return max;
	}
	
}
