package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Greedy01 {
    private static int N;
    private static int[] W, H;
    private static int answer;

    private static class Info implements Comparable<Info>{
        int height, weight;

        public Info(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return o.height - this.height;
        }
    }

    private static void Solution(ArrayList<Info> arr) {
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for(Info player : arr) {
            if (max < player.weight) {
                max = player.weight;
                answer++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Info> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            arr.add(new Info(h, w));
        }
        br.close();
        Solution(arr);
        System.out.println(answer);
    }
}
