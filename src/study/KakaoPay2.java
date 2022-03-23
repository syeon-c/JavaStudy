package study;

import java.util.Arrays;

public class KakaoPay2 {

  /**
   * 스와이프 방향 1 : 아래로 2 : 위로 3 : 우로 4 : 좌로
   * @param args
   */
  public static void main(String[] args) {
    int[] result = solution(4, 3, new int[][]{{1, 1, 2, 4, 3}, {3, 2, 1, 2, 3}, {4, 1, 1, 4, 3}, {2, 2, 1, 3, 3}});
    Arrays.stream(result).forEach(
        t-> System.out.println(t)
    );
  }

  public static int[] solution(int rows, int columns, int[][] swipes) {
    int[] result = new int[swipes.length]; // 결과 배열
    int[][] matrix = new int[rows][columns]; // 행열 배열

    // make matrix
    int cnt = 1;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        matrix[i][j] = cnt++;
      }
    }

    for (int i = 0; i < swipes.length; i++) {
      int[][] dummy = new int[rows][columns]; // 더미 배열 초기화
      int direction = swipes[i][0];
      int rowStart = swipes[i][1];
      int columnStart = swipes[i][2];
      int rowEnd = swipes[i][3];
      int columnEnd = swipes[i][4];

      if (direction == 1) {
        // 아래로 이동
        for (int k = columnStart; k <= columnEnd; k++) {
          dummy[rowStart - 1][k - 1] = matrix[rowEnd - 1][k - 1];
          result[i] += matrix[rowEnd - 1][k - 1];
        }
        for (int r = rowEnd - 1; r > rowStart - 1; r--) {
          for (int c = columnStart - 1; c <= columnEnd - 1; c++) {
            matrix[r][c] = matrix[r - 1][c];
          }
        }
        matrix = merge(dummy, matrix, rows, columns);
      } else if (direction == 2) {
        // 위로 이동
        for (int k = columnStart; k <= columnEnd; k++) {
          dummy[rowEnd - 1][k - 1] = matrix[rowStart - 1][k - 1];
          result[i] += matrix[rowStart - 1][k - 1];
        }
        for (int r = rowStart - 1; r < rowEnd - 1; r++) {
          for (int c = columnStart - 1; c <= columnEnd - 1; c++) {
            matrix[r][c] = matrix[r + 1][c];
          }
        }
        matrix = merge(dummy, matrix, rows, columns);
      } else if (direction == 3) {
        //우로 이동
        for (int k = rowStart; k <= rowEnd; k++) {
          dummy[k - 1][columnStart - 1] = matrix[k - 1][columnEnd - 1];
          result[i] += matrix[k - 1][columnEnd - 1];
        }
        for (int r = columnEnd - 1; r > columnStart - 1; r--) {
          for (int c = rowEnd - 1; c >= rowStart - 1; c--) {
            matrix[c][r] = matrix[c][r - 1];
          }
        }
        matrix = merge(dummy, matrix, rows, columns);
      } else {
        //좌로 이동
        for (int k = rowStart; k <= rowEnd; k++) {
          dummy[k - 1][columnEnd - 1] = matrix[k - 1][columnStart - 1];
          result[i] += matrix[k - 1][columnStart - 1];
        }
        for (int r = columnStart - 1; r < columnEnd - 1; r++) {
          for (int c = rowStart - 1; c <= rowEnd - 1; c++) {
            matrix[c][r] = matrix[c][r + 1];
          }
        }
        matrix = merge(dummy, matrix, rows, columns);
      }
    }
    return result;
  }

  public static int[][] merge(int a[][], int b[][], int rows, int columns) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (a[i][j] > 0) {
          b[i][j] = a[i][j];
        }
      }
    }
    return b;
  }

}
