package chapter1_arrays_and_strings;
/*
* isUnique - if string has all unique characters
*/


import java.util.HashSet;
import java.util.Scanner;

class IsUnique{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println("Without Using Additional DS : "+ isUniqueWithoutExtraDataStructure(s));
    System.out.println("With Using Additional DS : "+ isUniqueWithExtraDataStructure(s));
    sc.close();
  }

  private static boolean isUniqueWithExtraDataStructure(String s){
    HashSet<Character> chars = new HashSet<Character>();
    for(int i = 0; i< s.length();i++){
      if(chars.contains(s.charAt(i))){
        return false;
      }
      else{
        chars.add(s.charAt(i));
      }
    }
    return true;
  }

  private static boolean isUniqueWithoutExtraDataStructure(String s){
    for(int i = 0; i< s.length()-1;i++){
      if(s.substring(i+1, s.length()).indexOf(s.charAt(i)) > 0){
        return false;
      }
    }
    return true;
  }
}
