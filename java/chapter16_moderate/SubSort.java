package chapter16_moderate;

public class SubSort {

	public static void main(String[] args) {
		int[] arr = {1,2,3,7,8,6,11,15,8,9,5,14,17};
		printSubSortIndices(arr);
	}

	private static void printSubSortIndices(int[] arr) {
		int min = Integer.MAX_VALUE;
		int start = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (min < arr[i]) {
				start = i;
			}
			min = Math.min(arr[i],min);
		}
		
		int max = Integer.MIN_VALUE;
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max > arr[i]) {
				end = i;
			}
			max = Math.max(arr[i],max);
		}
		
		System.out.println(start + " " + end);
	}

}
