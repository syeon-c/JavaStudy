package Programmers.Level1;

public class TheRestIs1 {
    private static int solution(int n) {
        int answer = 0;
        for(int i = 2; i < n; i++) {
            if ((n-1) % i == 0) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }
}
