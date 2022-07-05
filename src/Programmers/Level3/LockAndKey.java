package Programmers.Level3;

/**
 * https://gre-eny.tistory.com/139
 */

import java.util.Arrays;

public class LockAndKey {
    private static boolean solution(int[][] key, int[][] lock) {
        int hole = 0;
        for(int i = 0; i < lock.length; i++) {
            for(int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0) hole++;
            }
        }
        // lock에 padding을 줘서 확장
        int[][] board = padding(lock, key.length);

        // 확장된 lock에서 key를 한 칸씩 밀면서 비교
        if (check(board, key, hole)) return true;

        // key를 90도, 180도, 270도 회전시킨 후, 확장된 lock에서 key를 한 칸씩 밀면서 비교
        for(int i = 0; i < 3; i++) {
            key = rotate(key);
            if (check(board, key, hole)) return true;
        }
        return false;
    }

    private static int[][] rotate(int[][] key) {
        return key;
    }

    private static boolean check(int[][] board, int[][] key, int hole) {
        return false;
    }

    private static int[][] padding(int[][] lock, int key_len) {
        int[][] board = new int[lock.length + (key_len - 1) * 2][lock.length + (key_len - 1) * 2];
        for(int[] b : board) {
            Arrays.fill(b, -1);
        }
        for(int i = key_len - 1; i < key_len - 1 + lock.length; i++) {
            for(int j = key_len - 1; j < key_len - 1 + lock.length; j++) {
                board[i][j] = lock[i - key_len + 1][j - key_len + 1];
            }
        }
        return board;
    }
}
