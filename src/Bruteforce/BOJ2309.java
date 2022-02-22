package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heights = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            sum += height;
            heights[i] = height;
        }
        int spy1 = 0, spy2 = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = i+1; j < 9; j++) {
                if (heights[i] + heights[j] == sum - 100) {
                    spy1 = heights[i];
                    spy2 = heights[j];
                    break;
                }
            }
        }
        Arrays.sort(heights);
        for(int h : heights) {
            if (h == spy1 || h == spy2) continue;
            else System.out.println(h);
        }
    }
}
