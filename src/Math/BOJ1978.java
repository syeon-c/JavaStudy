package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1978 {
    private static boolean isPrime(int num) {
        if (num == 1) return false;
        else {
            for(int i = 2; i < num; i++)
                if (num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        br.close();

        int answer = 0;
        for(int a : arr) { if (isPrime(a)) answer++; }
        System.out.println(answer);
    }
}