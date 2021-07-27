package chapter10_sorting_and_searching;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int[] a = {15,16,19,20,25,1,3,4,5,7,10,14};
		int res = searchInRotatedArray(a, 0, a.length - 1, 5);
		if(res == -1) {
			System.out.println("Not Found");
		}
		else {
			System.out.println(res);
		}
	}
	
	public static int searchInRotatedArray(int a[], int low, int high, int n) {
		int mid = (low + high) / 2;
		
		if (n == a[mid]) { 
			return mid;
		}
		
		if (high < low) {
			return -1;
		}
		
		if (a[low] < a[mid]) { 
			if (n >= a[low] && n < a[mid]) { 
				return searchInRotatedArray(a, low, mid - 1, n);
			} else {
				return searchInRotatedArray(a, mid + 1, high, n);
			}
		} else if (a[mid] < a[high]) {
			if (n > a[mid] && n <= a[high]) {
				return searchInRotatedArray(a, mid + 1, high, n);
			} else {
				return searchInRotatedArray(a, low, mid - 1, n);
			}				
		} else if (a[low] == a[mid]) { 
			if (a[mid] != a[high]) { 
				return searchInRotatedArray(a, mid + 1, high, n);
			} else { 
				int resInd = searchInRotatedArray(a, low, mid - 1, n); 
				if (resInd == -1) {
					return searchInRotatedArray(a, mid + 1, high, n); 
				} else {
					return resInd;
				}
			}
		}
		return -1;
	}

}
