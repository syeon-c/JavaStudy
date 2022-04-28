package Programmers.Level2;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
    private static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        for(String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        return answer - 1;
    }
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}, {"crow_mask", "face"}};
        System.out.println(solution(clothes));
    }
}
