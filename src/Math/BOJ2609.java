package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2609 {
    private static long getGcd(long a, long b) {
        while (b > 0) {
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    private static long getLcm(long a, long b, long gcd) {
        return (a * b) / gcd;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        br.close();
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);

        Long gcd = getGcd(a, b);
        Long lcm = getLcm(a, b, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }
}