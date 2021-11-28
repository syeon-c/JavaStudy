package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DuplicateConfirmation {
    private static char Solution(int n, int[] arr) {
        char answer = 'U';
        Arrays.sort(arr);
        int key = arr[0];
        for(int i = 1; i < n; i++) {
            if (arr[i] == key) {
                answer = 'D';
                break;
            }
            key = arr[i];
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);
        br.close();
        System.out.println(Solution(N, arr));
    }
}
