package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JumpAndTeleport {
    private static int solution(int n) {
        int answer = 0;
        while (n != 0) {
            if (n % 2 == 0) n /= 2;
            else {
                n -= 1;
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(solution(n));
    }
}
