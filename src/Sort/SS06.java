package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SS06 {
    private static List<Integer> Solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int[] origin = arr.clone();
        Arrays.sort(origin);

        for(int i = 0; i < n; i++) {
            if (arr[i] != origin[i]) {
                answer.add(i + 1);
            }
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
        for(int a : Solution(N, arr))
            System.out.print(a + " ");
    }
}
