package Programmers.Level2;

public class TruncateN2Array {
    private static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int index = 0;
        for(long i = left; i <= right; i++) {
            long row = i / n;
            long col = i % n;
            answer[index++] = Math.max((int) row + 1, (int) col + 1);
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 3;
        long left = 2;
        long right = 5;
        for(int i : solution(n, left, right)) {
            System.out.print(i + " ");
        }
    }
}
