package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class String04 {
    private static void Solution(int n, String[] arr) {
        ArrayList<String> answer = new ArrayList<>();
        for(String s : arr) {
            String str = new StringBuilder(s).reverse().toString();
            answer.add(str);
        }
        for(String a : answer) {
            System.out.println(a);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            arr[i] = str;
        }
        Solution(N, arr);
    }
}
