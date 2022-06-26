package Programmers.Level2;

import java.util.*;

public class MenuRenewal {
    private static List<String> answerList = new ArrayList<>();
    private static HashMap<String, Integer> countOfOrder;
    private static String[] solution(String[] orders, int[] course) {
        // 주문 알파벳 정렬
        for(int i = 0; i < orders.length; i++) {
            char[] tmp = orders[i].toCharArray();
            Arrays.sort(tmp);
            orders[i] = String.valueOf(tmp);
        }
        // 코스별 요리 주문 횟수 구하기
        for(int c : course) {
            countOfOrder = new HashMap<>();
            for(String order : orders) {
                dfs("", order, c);
            }
            // 최대 요리 주문 횟수 구하기
            List<Integer> countList = new ArrayList<>(countOfOrder.values());
            int max = Collections.max(countList);
            // 조건 : 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
            if (max > 1) {
                for(String key : countOfOrder.keySet()) {
                    if (countOfOrder.get(key) == max) answerList.add(key);
                }
            }
        }
        Collections.sort(answerList);
        String[] result = answerList.toArray(new String[answerList.size()]);
        return result;
    }

    private static void dfs(String s, String order, int c) {
        if (s.length() == c) {
            countOfOrder.put(s, countOfOrder.getOrDefault(s, 0) + 1);
            return;
        }
        for(int i = 0; i < order.length(); i++) {
            dfs(s + order.charAt(i), order.substring(i + 1), c);
        }
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        solution(orders, course);
    }
}
