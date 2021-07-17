package chapter1_arrays_and_strings;
/*
* checkPermutation - if one string is permutation of another
*/


import java.util.Scanner;

class CheckPermutation{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    System.out.println(checkPermutation(s1,s2));
    sc.close();
  }

  private static boolean checkPermutation(String s1, String s2){
    if(s1.length() != s2.length()){
      return false;
    }

    int[] charCount = new int[128];
    for(int i = 0; i< s1.length();i++){
      charCount[s1.charAt(i)]++;
    }
    for(int i = 0; i< s2.length();i++){
      charCount[s2.charAt(i)]--;
      if(charCount[s2.charAt(i)] < 0){
        return false;
      }
    }

    return true;
  }
}
