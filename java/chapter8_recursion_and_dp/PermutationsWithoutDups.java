package chapter8_recursion_and_dp;

import java.util.HashSet;
import java.util.Set;

public class PermutationsWithoutDups {
	public static void main(String[] args) {
		Set<String> res = getPermutations("abcde");
		for(String s:res) {
			System.out.println(s);
		}
	}

	private static Set<String> getPermutations(String s) {
		Set<String> res = new HashSet<String>();
		if(s.length() == 0) {
			res.add("");
			return res;
		}
		
		Set<String> prev = getPermutations(s.substring(1));
		char c = s.charAt(0);
		for(int i = 0; i < s.length();i++) {
			for(String p : prev) {
				res.add(p.substring(0,i) + c + p.substring(i));
			}
		}
		return res;
	}
}
