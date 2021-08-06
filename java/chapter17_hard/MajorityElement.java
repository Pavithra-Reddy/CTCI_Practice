package chapter17_hard;

public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = {5,1,5,3,3,5,5,4,5,5,2};
		int ele = findMaximumCountEle(arr);
		if(isMajorityElement(arr, ele)) {
			System.out.println(ele);
		} else {
			System.out.println("No Majority Element");
		}

	}

	private static boolean isMajorityElement(int[] arr, int ele) {
		int c = 0;
		for(int n : arr) {
			if(n == ele) {
				c++;
			}
		}
		
		return c > (arr.length/2);
	}

	private static int findMaximumCountEle(int[] arr) {
		if(arr.length == 0) {
			return 0;
		}
		int c = 1;
		int majEle = arr[0];
		for(int i = 1; i< arr.length; i++) {
			if(majEle == arr[i]) {
				c++;
			} else if(c == 1) {
				majEle = arr[i];
			} else {
				c--;
			}
		}
		return majEle;
	}

}
