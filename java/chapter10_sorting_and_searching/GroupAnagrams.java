package chapter10_sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] arr = {"abc" , "def", "abb", "cba","fed","bac","xyz","test"};
		sortGroupAnagrams(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static void sortGroupAnagrams(String[] arr) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(int i = 0; i < arr.length; i++) {
			ArrayList<String> ls = new ArrayList<String>();
			if(map.containsKey(getSortedString(arr[i]))) {
				ls = map.get(getSortedString(arr[i]));
			}
			ls.add(arr[i]);
			map.put(getSortedString(arr[i]), ls);
		}
		int j = 0;
		for(String s : map.keySet()) {
			ArrayList<String> ls = map.get(s);
			for(int i = 0; i < ls.size(); i++) {
				arr[j++] = ls.get(i);
			}
		}
	}

	private static String getSortedString(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

}
