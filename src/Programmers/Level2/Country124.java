package Programmers.Level2;

public class Country124 {
    private static String solution(int n) {
        String answer = "";

        if (n == 1) return "1";

        if (n == 2) return "2";

        while (n > 0) {
            int tmp = n % 3;
            n /= 3;
            if (tmp == 0) {
                n -= 1;
                tmp = 4;
            }
            answer = tmp + answer;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 13;
        System.out.println(solution(n));
    }
}
