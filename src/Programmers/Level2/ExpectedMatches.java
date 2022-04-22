package Programmers.Level2;

public class ExpectedMatches {
    private static int solution(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            answer++;
            if (a % 2 == 1) a += 1;
            if (b % 2 == 1) b += 1;
            a /= 2;
            b /= 2;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 8;
        int a = 1;
        int b = 8;
        System.out.println(solution(n, a, b));
    }
}
