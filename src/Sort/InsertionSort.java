package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {
    private static void Solution(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for(j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) arr[j + 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }
        for(int a : arr)
            System.out.print(a + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        br.close();
        Solution(N, arr);
    }
}
