package chapter1_arrays_and_strings;
/*
* RotateMatrix - rotate matrix to 90 deg
*/

import java.util.Scanner;

class RotateMatrix{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[][] mat = new int[n][n];
    for(int i =  0; i < n; i++){
      for(int j = 0; j < n; j++){
        mat[i][j] = sc.nextInt();
      }
    }
    rotate(mat, n);
    printMatrix(mat,n);
    sc.close();
  }

  private static void rotate(int[][] mat, int n){
    for(int i = 0; i<n/2;i++){
      for(int j = i; j < n-1-i ; j++){
        int temp = mat[i][j];
        mat[i][j] = mat[n-j-1][i];
        mat[n-j-1][i] = mat[n-i-1][n-j-1];
        mat[n-i-1][n-j-1] = mat[j][n-i-1];
        mat[j][n-i-1] = temp;
        //printMatrix(mat,n);
      }
    }
  }

  private static void printMatrix(int[][] mat, int n){
    System.out.println("######################################");
    for(int i = 0; i<n;i++){
      for(int j = 0; j < n; j++){
          System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
  }
}
