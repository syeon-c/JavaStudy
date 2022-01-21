package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2004 {
    private static long getCntTwo(long num) {
        long cntTwo = 0;

        while (num >= 2) {
            cntTwo += num / 2;
            num /= 2;
        }
        return cntTwo;
    }

    private static long getCntFive(long num) {
        long cntFive = 0;
        while (num >= 5) {
            cntFive += num / 5;
            num /= 5;
        }
        return cntFive;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);

        // 여기서 0의 개수는 2와 5의 겹치는 승수의 값과 같다. 즉, n!, (n-m)!, m! 의 2와 5의 승수를 구한다.
        long cnt2 = getCntTwo(n) - getCntTwo(n - m) - getCntTwo(m);
        long cnt5 = getCntFive(n) - getCntFive(n - m) - getCntFive(m);
        // 여기서 2의 승수(a1 - b1, c1) 와 5의 승수(a2 - b2 - c2) 가 구해졌으면 이제 겹치는(짝지을 수 있는) 개수를 구하면 되므로, 2와 5의 승수 중 최솟값을 출력하면 된다.
        System.out.println(Math.min(cnt2, cnt5));
    }
}
