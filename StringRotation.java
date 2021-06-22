/*
* StringRotation - if one string is obtained by rotating another string
*/


import java.util.*;

class StringRotation{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    s2 = s2 + s2;
    System.out.println(isSubString(s1,s2));
  }

  private static boolean isSubString(String s1, String s2){
    return s2.contains(s1);
  }
}
