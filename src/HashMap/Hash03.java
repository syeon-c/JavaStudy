package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hash03 {
    private static void Solution(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // k - 1일까지 매출액 맵 생성
        for(int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        // Sliding Window
        int lp = 0;
        for(int rp = k - 1; rp < n; rp++) {
            // k번째 매출액 맵에 추가
            map.put(arr[rp], map.getOrDefault(arr[rp], 0) + 1);
            // 연속 n일째 구간의 매출액 종류의 개수 추가
            answer.add(map.size());
            // lp 이동(n+1일째)
            map.replace(arr[lp], map.get(arr[lp]) - 1);
            if (map.get(arr[lp]) == 0) map.remove(arr[lp]);
            lp++;
        }

        for(int a : answer)
            System.out.print(a + " ");
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
