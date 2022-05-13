package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compression {
    private static HashMap<String, Integer> dictionary = new HashMap<>() {
        {
            put("A", 1);
            put("B", 2);
            put("C", 3);
            put("D", 4);
            put("E", 5);
            put("F", 6);
            put("G", 7);
            put("H", 8);
            put("I", 9);
            put("J", 10);
            put("K", 11);
            put("L", 12);
            put("M", 13);
            put("N", 14);
            put("O", 15);
            put("P", 16);
            put("Q", 17);
            put("R", 18);
            put("S", 19);
            put("T", 20);
            put("U", 21);
            put("V", 22);
            put("W", 23);
            put("X", 24);
            put("Y", 25);
            put("Z", 26);
        }};
    private static List<Integer> compress = new ArrayList<>();
    private static int[] solution(String msg) {
        LZW(msg);
        int[] answer = new int[compress.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = compress.get(i);
        return answer;
    }

    private static void LZW(String msg) {
        for(int i = 0; i < msg.length(); i++) {
            String word = msg.substring(0, i + 1);
            // 사전에 없으면 사전에 색인 등록 > 이전 문자열의 색인 출력
            if (!dictionary.containsKey(word)) {
                dictionary.put(word, dictionary.size() + 1);
                compress.add(dictionary.get(msg.substring(0, i)));
                LZW(msg.substring(i));
                break;
            } else {
                // 마지막 문자 색인 출력
                if (i + 1 == msg.length()) {
                    compress.add(dictionary.get(msg.substring(0, i + 1)));
                }
            }
        }
    }

    public static void main(String[] args) {
        String msg = "KAKAO";
        System.out.println(solution(msg));
    }
}
