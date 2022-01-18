package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        br.close();
        String[] answer = new String[S.length()];
        for(int i = 0; i < S.length(); i++) {
            answer[i] = S.substring(i);
        }
        Arrays.sort(answer);
        for(String s : answer) System.out.println(s);
    }
}