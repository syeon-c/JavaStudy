package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        char key = 'a';
        while (Character.isAlphabetic(key)) {
            map.put(key, 0);
            key++;
        }
        for(char c : S) {
            map.put(c, map.get(c) + 1);
        }
        for(int value : map.values())
            System.out.print(value + " ");
    }
}