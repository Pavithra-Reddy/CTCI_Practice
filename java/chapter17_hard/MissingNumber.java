package chapter17_hard;

import java.util.ArrayList;
import java.util.List;

public class MissingNumber {
	
	public static void main(String[] args) {
		int n = 19;
        List<Integer> arr = new ArrayList<Integer>();
        int k = 14;
        for(int i = 0; i <= n; i++) {
        	if(i == k) {
        		continue;
        	}
        	else {
        		arr.add(i);
        	}
        }
        
        int res =  getMissing(arr,0,Integer.toBinaryString(n).length()-1);
        System.out.println(res);
	}

	private static int getMissing(List<Integer> arr, int j, int bitCount) {
    	if (j > bitCount) { 
    		return 0;
    	}
    	List<Integer> arr0 = new ArrayList<Integer>();
    	List<Integer> arr1 = new ArrayList<Integer>();
    	
        for (int i = 0; i < arr.size(); i++) {
            if (fetch(arr.get(i), j) == 0) {
            	arr0.add(arr.get(i));
            } else {
            	arr1.add(arr.get(i));
            }
        }
        
        if (arr0.size() <= arr1.size()) {
        	int num = getMissing(arr0, j + 1, bitCount);
            return (num << 1) | 0;
        } else {
        	int num = getMissing(arr1, j + 1, bitCount);
            return (num << 1) | 1;
        }
	}

	private static int fetch(int num, int j) {
		String s = Integer.toBinaryString(num);
		return j < s.length() && s.charAt(s.length()-1-j) == '1'? 1 : 0;
	}
	
}

