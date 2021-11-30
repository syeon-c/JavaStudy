package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Stables {
    private static int count(int[] arr, int dist) {
        int cnt = 1;
        int endPos = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] - endPos >= dist) {
                cnt++;
                endPos = arr[i];
            }
        }
        return cnt;
    }
    private static int Solution(int n, int c, int[] xi) {
        int answer = 0;
        Arrays.sort(xi);
        int lp = 1;
        int rp = xi[n - 1];
        while (lp <= rp) {
            int mid = (lp + rp) / 2;
            if (count(xi, mid) >= c) {
                answer = mid;
                lp = mid + 1;
            } else rp = mid - 1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int C = Integer.parseInt(info[1]);
        String[] input = br.readLine().split(" ");
        int[] xi = new int[N];
        for(int i = 0 ; i < N; i++)
            xi[i] = Integer.parseInt(input[i]);
        br.close();
        System.out.println(Solution(N, C, xi));
    }
}
