/*
* StringCompression - compresses string by appending number of repeating characters
*/

import java.util.*;

class StringCompression{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    System.out.println(compressString(s));
  }

  private static String compressString(String s){
    int c = 1;
    String compressedString = "" + s.charAt(0);
    for(int i = 1; i < s.length();i++){
      if(s.charAt(i) == s.charAt(i-1)){
        c++;
      }
      else{
        compressedString += c;
        compressedString += s.charAt(i);
        c = 1;
      }
    }
    compressedString +=c;
    if(compressedString.length() < s.length()){
      return compressedString;
    }
    else {
      return s;
    }
  }
}
