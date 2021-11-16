package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;

public class Hash05 {
    private static void Solution(int n, int k, int[] arr) {
        int answer = -1;
        // 트리 세트 내림차순 정렬
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        // 카드 3장을 뽑아서 나오는 합의 경의 모두 구하기
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int z = j + 1; z < n; z++) {
                    Tset.add(arr[i] + arr[j] + arr[z]);
                }
            }
        }
        int cnt = 0;
        for(int i : Tset) {
            cnt++;
            if (cnt == k) answer = i;
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]);

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        br.close();
        Solution(N, K, arr);
    }
}
