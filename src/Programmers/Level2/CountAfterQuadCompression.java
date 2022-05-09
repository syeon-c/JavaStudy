package Programmers.Level2;

public class CountAfterQuadCompression {
    private static int[] answer = new int[2];

    private static int[] solution(int[][] arr) {
        int arrLen = arr.length;
        dq(0, 0, arrLen, arr);
        return answer;
    }

    private static void dq(int startX, int startY, int size, int[][] arr) {
        if (check(startX, startY, size, arr)) {
            answer[arr[startX][startY]]++;
            return;
        }
        dq(startX, startY, size / 2, arr);
        dq(startX + (size / 2), startY, size / 2, arr);
        dq(startX, startY + (size / 2), size / 2, arr);
        dq(startX + (size / 2), startY + (size / 2), size / 2, arr);
    }

    // 모든 수가 같은 값인지 확인 -> 쿼드 분할 가능성 체크
    private static boolean check(int x, int y, int size, int[][] arr) {
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        solution(arr);
    }
}
