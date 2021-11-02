package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class String11 {
    /**Solution1: 링크드해쉬맵 자료구조 이용 방법 */
    private static void Solution(String str) {
        /** 순서가 보장되는 HashMap > LinkedHashMap */
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(Character c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.replace(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(Character c : map.keySet()) {
            if (map.get(c) == 1) {
                System.out.print(c);
            } else {
                System.out.print(c);
                System.out.print(map.get(c));
            }
        }
    }
    /**Solution2: 문자열 탐색 방법
     * 1) 현재 탐색 중인 알파벳과 다른 값의 알파벳이 나올 때까지 cnt 변수 증가
     * 2) 다른 값의 알파벳이 나오면, 알파벳 출력하고 cnt 값 출력(1보다 클 경우)
     *    다시 cnt 변수 1로 초기화
     * */
    private static void Solution2(String str) {
        String answer = "";
        str += " ";
        int cnt = 1;
        // 추가해준 공백 전까지 탐색
        for(int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                cnt++;
            else {
                answer += str.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                    cnt = 1;
                }
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        Solution(input);
        System.out.println();
        Solution2(input);
    }
}
