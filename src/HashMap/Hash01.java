package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class Hash01 {
    private static void Solution(int n, String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        // inflearn 수강 후 개선 코드
        for(Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        /** 내가 작성한 코드
         * for(int i = 0; i < n; i++) {
         *             char c = str.charAt(i);
         *             if (map.containsKey(c)) {
         *                 map.replace(c, map.get(c) + 1);
         *             } else {
         *                 map.put(c, 1);
         *             }
         *         }
         */

        // Comparator 클래스 이용한 해쉬맵 최댓값 구하기
        Comparator<Entry<Character, Integer>> comparator = new Comparator<Entry<Character, Integer>>() {
            @Override
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };
        Entry<Character, Integer> answer = Collections.max(map.entrySet(), comparator);

        // 반복문 이용한 해쉬맵 최댓값 구하기
        int max = Integer.MIN_VALUE;
        Character result = ' ';
        for(Character c : map.keySet()) {
            if (max < map.get(c)) {
                max = map.get(c);
                result = c;
            }
        }
        System.out.println(answer.getKey());
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        br.close();
        Solution(N, input);
    }
}
