package Array;

/**
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array08 {
    private static void Solution(int n, int[] arr) {
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;
        }
        for(int a : answer)
            System.out.print(a + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(input[i]);
        }
        br.close();
        Solution(N, score);
    }
}
