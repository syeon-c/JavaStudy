package Programmers.Level1;

import java.util.Stack;

/**
 * N x N 크기의 인형 옮기기 게임에서 제거한 인형의 개수 세기
 * [][][] -> []
 * [][][] -> []
 * [][][] -> []
 * 제거 조건 : 오른쪽 바구니에 인형들을 옮기고 같은 모양의 인형 두 개가 바구니에 연속해서 쌓일 경우
 */

public class CraneClawMachineGame {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int m : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][m - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[i][m - 1]);
                        board[i][m - 1] = 0;
                        break;
                    }
                    if (board[i][m - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[i][m - 1]);
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
