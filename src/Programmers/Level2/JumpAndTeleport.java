package Programmers.Level2;

public class JumpAndTeleport {
    private static int solution(int n) {
        int answer = 0;
        while (n != 0) {
            if (n % 2 == 0)
                n /= 2;
            else {
                n--;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 5000;
        System.out.println(solution(n));
    }
}
