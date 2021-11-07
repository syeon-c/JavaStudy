package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램 을 작성하세요.
 *
 * ▣ 입력설명
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * ▣ 출력설명
 * 오름차순으로 정렬된 배열을 출력합니다.
 */

public class TP01 {
    private static void Solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] < arr2[p2])
                answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        // 아직 남아있는 요소가 있을 경우
        while (p1 < n) {
            answer.add(arr1[p1++]);
        }
        while (p2 < m) {
            answer.add(arr2[p2++]);
        }

        for(int a : answer) {
            System.out.print(a + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 배열 생성
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        String[] input1 = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(input1[i]);
        }
        // 두 번째 배열 생성
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(input2[i]);
        }
        br.close();
        Solution(N, M, arr1, arr2);
    }
}
