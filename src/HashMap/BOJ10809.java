package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        br.close();
        Map<Character, Integer> map = new HashMap<>();
        char key = 'a';
        while (Character.isAlphabetic(key)) {
            map.put(key, -1);
            key++;
        }
        for(int i = 0; i < S.length; i++) {
            if (map.get(S[i]) != -1) continue;
            else map.replace(S[i], i);
        }
        for(int value : map.values())
            System.out.print(value + " ");
    }
}