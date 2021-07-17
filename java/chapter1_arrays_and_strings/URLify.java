package chapter1_arrays_and_strings;
/*
* URLify - replace spaces to %20
*/

import java.util.Scanner;

class URLify{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    int originalLen = s.length();
    for(int i = 0; i< originalLen;i++){
      if(s.charAt(i) == ' '){
        s = s + " " + " ";
      }
    }

    System.out.println(urlify(s.toCharArray(), originalLen));
    sc.close();
  }

  private static char[] urlify(char[] arr, int j){
    j--;
    for(int i = arr.length - 1; i >= 0; i--){
      if(arr[j] == ' '){
          arr[i--]='0';
          arr[i--]='2';
          arr[i]='%';
          j--;
      }
      else{
        arr[i] = arr[j--];
      }
    }
    return arr;
  }
}
