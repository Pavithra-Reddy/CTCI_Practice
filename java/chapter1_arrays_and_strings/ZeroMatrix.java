package chapter1_arrays_and_strings;
/*
* ZeroMatrix - make row and column to 0 if element is 0
*/

import java.util.HashSet;
import java.util.Scanner;

class ZeroMatrix{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int[][] mat = new int[m][n];
    for(int i =  0; i < m; i++){
      for(int j = 0; j < n; j++){
        mat[i][j] = sc.nextInt();
      }
    }
    makeZeroMatrix(mat, m, n);
    printMatrix(mat,m, n);
    sc.close();
  }

  private static void makeZeroMatrix(int[][] mat, int m, int n){
    HashSet<Integer> zeroColumns = new HashSet<Integer>();
    HashSet<Integer> zeroRows = new HashSet<Integer>();
    for(int i = 0; i<m; i++){
      for(int j = 0; j < n; j++){
        if(mat[i][j] == 0){
          zeroRows.add(i);
          zeroColumns.add(j);
        }
      }
    }

    for(int i = 0; i<m; i++){
      for(int j = 0; j < n; j++){
        if(zeroRows.contains(i) || zeroColumns.contains(j)){
          mat[i][j] = 0;
        }
      }
    }

  }

  private static void printMatrix(int[][] mat, int m, int n){
    System.out.println("######################################");
    for(int i = 0; i<m; i++){
      for(int j = 0; j < n; j++){
          System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }
}
