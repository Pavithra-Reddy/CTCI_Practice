package chapter1_arrays_and_strings;
/*
* PalindromePermutation - if it's permutation is palindrome or not
*/


import java.util.Scanner;

class PalindromePermutation{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(isPermutationPalindrome(s));
    sc.close();
  }

  private static boolean isPermutationPalindrome(String s){
    int charCount = 0;
    int len = 0;
    for(int i = 0; i < s.length() ;i++){
      int c = s.charAt(i);

      if(s.charAt(i) == ' ')
        continue;

      if((charCount & (1 << c)) != 0){
        charCount  &=  (~(1<<c));
      }
      else{
        charCount |= (1 << c);
      }
      len++;
    }

    if(len%2 == 0 && charCount == 0){
      return true;
    }
    else if(len%2 != 0 && (charCount & (charCount-1)) == 0){
      return true;
    }
    else{
      return false;
    }

  }
}
