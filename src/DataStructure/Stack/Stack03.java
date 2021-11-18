package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack03 {
    private static void Solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int x : moves) {
            for(int i = 1; i <= n; i++) {
                if (board[i][x] != 0) {
                    // 인형 터뜨리기
                    if (!stack.empty() && stack.peek() == board[i][x]) {
                        stack.pop();
                        // 인형은 한 번에 두 개씩 터진다
                        answer += 2;
                    } else {
                        stack.push(board[i][x]);
                    }
                    board[i][x] = 0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // N*N board
        int[][] board = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                board[i][j+1] = Integer.parseInt(input[j]);
            }
        }
        // 크레인 작동 위치
        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            moves[i] = Integer.parseInt(input2[i]);
        }
        br.close();
        Solution(N, board, M, moves);
    }
}
