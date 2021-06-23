/*
* OneAway - if one string is one edit away from another string
*/

import java.util.*;

class OneAway{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    if(Math.abs(s1.length() - s2.length()) > 1 ){
      System.out.println("false");
      return;
    }
    if(s1.length() < s2.length()){
      String temp = s1;
      s1 = s2;
      s2 = temp;
    }
    System.out.println(isOneEditAway(s1, s2));
  }

  private static boolean isOneEditAway(String s1, String s2){
    HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
    int j = 0;
    int diff = 0;
    for(int i = 0; i < s1.length(); i++){
      if(j >= s2.length() || s1.charAt(i) != s2.charAt(j)){
        diff++;
        if(diff > 1){
          return false;
        }
        if(s1.length() == s2.length()){
          j++;
        }
      }
      else{
        j++;
      }
    }
    return true;

  }
}
