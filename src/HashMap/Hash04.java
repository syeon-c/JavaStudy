package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Hash04 {
    private static void Solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> t_map = new HashMap<>();
        for(Character c : t.toCharArray()) {
            t_map.put(c, t_map.getOrDefault(c, 0) + 1);
        }

        // lp-rp까지 t_map과 비교할 map
        HashMap<Character, Integer> map = new HashMap<>();
        int k = t.length() - 1;
        for(int i = 0; i < k; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // Two Pointers
        int lp = 0;
        for(int rp = k; rp < s.length(); rp++) {
            map.put(s.charAt(rp), map.getOrDefault(s.charAt(rp), 0) + 1);
            // map 비교 후 같으면 answer + 1
            if (map.equals(t_map)) answer++;
            // lp 이동
            map.put(s.charAt(lp), map.get(s.charAt(lp)) - 1);
            if (map.get(s.charAt(lp)) == 0) map.remove(s.charAt(lp));
            lp++;
        }

        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        Solution(S, T);
    }
}
