package TwoPointers;

/**
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로 그램을 작성하세요.
 *
 * ▣ 입력설명
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 *
 * ▣ 출력설명
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TP02 {
    private static void Solution(int n, int m, int[] set1, int[] set2) {
        ArrayList<Integer> answer = new ArrayList<>();
        // 각각의 집합 오름차순 정렬
        Arrays.sort(set1);
        Arrays.sort(set2);
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (set1[p1] == set2[p2]) {
                answer.add(set1[p1++]);
                p2++;
            } else if (set1[p1] < set2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        for(int a : answer)
            System.out.print(a + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 집합 생성
        int N = Integer.parseInt(br.readLine());
        int[] set1 = new int[N];
        String[] input1 = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            set1[i] = Integer.parseInt(input1[i]);
        }
        // 두 번째 집합 생성
        int M = Integer.parseInt(br.readLine());
        int[] set2 = new int[M];
        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            set2[i] = Integer.parseInt(input2[i]);
        }
        br.close();
        Solution(N, M, set1, set2);
    }
}
