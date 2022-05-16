package Programmers.Level2;

public class ExpressionOfNumbers {
    private static int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            int sum = i;
            int add = i + 1;
            while (sum < n) {
                sum += add++;
            }
            if (sum == n) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(solution(n));
    }
}
