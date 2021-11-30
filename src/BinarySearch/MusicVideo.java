package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MusicVideo {
    // 용량 크기 만큼 담을 수 있는 동영상 수 세기
    private static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for(int a : arr) {
            if (sum + a > capacity ) {
                cnt++;
                sum = a;
            } else sum += a;
        }
        return cnt;
    }
    private static int Solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lp = Arrays.stream(arr).max().getAsInt();
        int rp = Arrays.stream(arr).sum();

        while (lp <= rp) {
            int mid = (lp + rp) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rp = mid - 1;
            } else lp = mid + 1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        br.close();
        System.out.println(Solution(N, M, arr));
    }
}
