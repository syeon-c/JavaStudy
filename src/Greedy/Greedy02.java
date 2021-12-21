package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Greedy02 {
    private static int N;
    private static int answer;

    private static class Info implements Comparable<Info> {
        int start, end;

        public Info(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        // 끝나는 시간을 기준으로 오름차순 정렬, 만약 끝나는 시간이 같다면 먼저 시작하는 시간 순으로 정렬
        public int compareTo(Info o) {
            if (this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }

    private static void Solution(ArrayList<Info> arr) {
        Collections.sort(arr);
        int endTime = 0;
        for(Info time : arr) {
            if (time.start >= endTime) {
                answer++;
                endTime = time.end;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Info> arr = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            arr.add(new Info(s, e));
        }
        br.close();
        Solution(arr);
        System.out.println(answer);
    }
}
