package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        long[] values = new long[N+2];

        values[0] = values[1] = 1;
        if (N >= 2) {
            for(int i = 2; i <= N; i++)
                values[i] = values[i-1] * i;
        }

        System.out.println(values[N]);
    }
}
