package Programmers.Level1;

import java.util.Stack;

public class CraneClawMachine {
    private static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for(int m : moves) {
            for(int i = 0; i < board.length; i++) {
                if (board[i][m - 1] != 0) {
                    if (!bucket.isEmpty()) {
                        if (bucket.peek() == board[i][m - 1]) {
                            bucket.pop();
                            answer += 2;
                        } else bucket.push(board[i][m - 1]);
                        board[i][m - 1] = 0;
                    } else {
                        bucket.push(board[i][m - 1]);
                        board[i][m - 1] = 0;
                    }
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {0, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }
}
