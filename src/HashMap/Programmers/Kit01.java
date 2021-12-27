package HashMap.Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Kit01 {
    private static String answer;
    private static void solution2(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        // 선수 해쉬맵 생성
        for(String s : participant) map.put(s, map.getOrDefault(s, 0) + 1);
        // 완주자 해쉬맵 생성
        for(String s : completion) map.replace(s, map.get(s) - 1);

        for(String key : map.keySet()) {
            if (map.get(key) != 0) answer = key;
        }
    }
    private static void solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        // 완주자 해쉬맵 생성
        for(String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // 참가자 중 완주하지 못한 선수 탐색
        for(String s : participant) {
            if (map.containsKey(s)) {
                if (map.get(s) == 0) {
                    answer = s; return;
                } else map.replace(s, map.get(s) - 1);
            } else {
                answer = s; return;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] participant = br.readLine().split(" ");
        String[] completion = br.readLine().split(" ");
        br.close();
        solution2(participant, completion);
        System.out.println(answer);
    }
}
