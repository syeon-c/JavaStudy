package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    private static int Solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lp = 0, rp = n - 1;

        while (lp <= rp) {
            int mid = (lp + rp) / 2;
            if (arr[mid] ==m) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > m) rp = mid - 1;
            else lp = mid + 1;
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
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        br.close();
        System.out.println(Solution(N, M, arr));
    }
}
