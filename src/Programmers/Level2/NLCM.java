package Programmers.Level2;

/**
 * 유클리드 호제법
 */

public class NLCM {
    private static int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i < arr.length; i++) {
            answer = getLCM(answer, arr[i]);
        }
        return answer;
    }
    private static int getGCD(int a, int b) {
        while (b > 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private static int getLCM(int a, int b) {
        return (a * b) / getGCD(a, b);
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 8, 14};
        System.out.println(solution(arr));
    }
}
