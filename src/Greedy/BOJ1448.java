package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = -1;
        int n = Integer.parseInt(br.readLine());

        Integer lines[] = new Integer[n];

        for(int i = 0; i < n; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lines, Collections.reverseOrder());

        for(int i = 0; i< n-2 ;i++) {
            if(lines[i] < lines[i + 1] + lines[i + 2]) {
                answer = lines[i] + lines[i + 1] + lines[i + 2];
            }
            if(answer > -1) break;

        }

        bw.write(String.valueOf(answer));
        bw.flush();
        return;
    }
}