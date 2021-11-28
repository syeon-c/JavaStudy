package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LRU {
    private static int[] Solution(int s, int n, int[] arr) {
        int[] cache = new int[s];
        Arrays.fill(cache, 0);
        for(int task : arr) {
            int pos = -1;
            // Cache에 원하는 작업이 있는지 탐색
            for(int i = 0; i < s; i++) {
                if (task == cache[i])
                    pos = i;
            }
            int start;
            // Cache Miss
            if (pos == -1) start = s - 1;
            // Cache Hit
            else start = pos;
            for (int i = start; i >= 1; i--)
                cache[i] = cache[i - 1];
            cache[0] = task;
        }
        return cache;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int S = Integer.parseInt(info[0]);
        int N = Integer.parseInt(info[1]);
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        br.close();
        for(int a : Solution(S, N, arr))
            System.out.print(a + " ");
    }
}
