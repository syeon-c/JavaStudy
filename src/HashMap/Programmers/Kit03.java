package HashMap.Programmers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Kit03 {
    static String[][] clothes;
    private static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        for(String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        answer--;
        return answer;
    }
    public static void main(String[] args) throws IOException {
        clothes = new String[][]
                {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
}
