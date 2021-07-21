package chapter10_sorting_and_searching;

public class PeaksAndValleys {

	public static void main(String[] args) {
		int[] arr = {1,3,2,4,2,5,6,7,8,9,1,2};
		reorder(arr);
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void reorder(int[] arr) {
		for(int i = 1; i < arr.length; i += 2) {
			int minInd = getMinValueIndex(arr,i-1,i,i+1);
			if(minInd != i) {
				int temp = arr[minInd];
				arr[minInd] = arr[i];
				arr[i] = temp;
			}
		}
	}

	private static int getMinValueIndex(int[] arr, int i1, int i2, int i3) {
		int len = arr.length;
		int min;
		if(i3>len-1) {
			min = Math.min(arr[i1], arr[i2]);
		}
		else {
			min = Math.min(arr[i3], Math.min(arr[i1], arr[i2]));
		}
		
		if(min == arr[i1]) {
			return i1;
		}
		else if(min == arr[i2]) {
			return i2;
		}
		else {
			return i3;
		}
		
	}

}
