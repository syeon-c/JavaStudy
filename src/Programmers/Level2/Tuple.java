package Programmers.Level2;

import java.util.*;

public class Tuple {
    private static int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b) -> { return a.length() - b.length(); });
        int[] answer = new int[arr.length];
        int idx = 0;
        for(String v : arr) {
            for(String n : v.split(",")) {
                if (set.add(n)) answer[idx++] = Integer.parseInt(n);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(solution(s));
    }
}
