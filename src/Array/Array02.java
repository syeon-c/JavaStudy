package Array;

/**
 * 선생님이 N명의 학생을 일렬로 세웠습니다.
 * 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
 * (어떤 학생이 자기 앞에 서 있는 학생들보다 크면 그 학생은 보이고, 작거나 같으면 보이지 않 습니다.)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array02 {
    private static int Solution(int N, int[] arr) {
        int answer = 1;
        int max = arr[0];

        for(int i = 1; i < N; i++) {
            if(arr[i] > max) {
                max = arr[i];
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        br.close();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(input[i]);

        System.out.println(Solution(N, arr));
    }
}
