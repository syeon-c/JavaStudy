package HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Hash02 {
    private static void Solution(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 첫 번째 단어 맵 생성
        for(Character c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 두 번째 단어와 첫 번째 단어 비교 -> key가 없거나 개수가 맞지 않으면 NO 출력, 아니면 value - 1
        for(Character c : s2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                System.out.println("NO");
                return;
            } else {
                map.replace(c, map.get(c) - 1);
            }
        }
        System.out.println("YES");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        br.close();
        Solution(str1, str2);
    }
}
