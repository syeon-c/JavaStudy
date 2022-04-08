package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixBorderRotation {
    static int[][] board;
    private static int rotating(int x1, int y1, int x2, int y2) {
        int min = board[x1 - 1][y1 - 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(board[x1 - 1][y1 - 1]);
        // x1 y1 -> x1 y2
        for(int y = y1; y < y2; y++) {
            if (min > board[x1 - 1][y]) min = board[x1 - 1][y];
            queue.offer(board[x1 - 1][y]);
            board[x1 - 1][y] = queue.poll();
        }
        // x1 y2 -> x2 y2
        for(int x = x1; x < x2; x++) {
            if (min > board[x][y2 - 1]) min = board[x][y2 - 1];
            queue.offer(board[x][y2 - 1]);
            board[x][y2 - 1] = queue.poll();
        }
        // x2 y2 -> x2 y1
        for(int y = y2-2; y >= y1-1; y--) {
            if (min > board[x2 - 1][y]) min = board[x2 - 1][y];
            queue.offer(board[x2 - 1][y]);
            board[x2 - 1][y] = queue.poll();
        }
        // x2 y1 -> x1 y1
        for(int x = x2 - 2; x >= x1-1; x--) {
            if (min > board[x][y1 - 1]) min = board[x][y1 - 1];
            queue.offer(board[x][y1 - 1]);
            board[x][y1 - 1] = queue.poll();
        }
        return min;
    }
    private static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int value = 1;
        // 초기 행렬 값 설정
        board = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                board[i][j] = value++;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotating(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }

        return answer;
    }
    public static void main(String[] args) {
        int r = 6;
        int c = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
        for(int n : solution(r, c, queries)) { System.out.print(n + " "); }
    }
}
