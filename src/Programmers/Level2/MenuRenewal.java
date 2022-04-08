package Programmers.Level2;

import java.util.*;

public class MenuRenewal {
    private static List<String> answer = new ArrayList<>();
    private static HashMap<String, Integer> countOfOrdered = new HashMap<>();

    private static void combinationDFS(String order, String orders, int count) {
        if (count == 0) {
            countOfOrdered.put(order, countOfOrdered.getOrDefault(order, 0) + 1);
            return;
        }

        for(int o = 0; o < orders.length(); o++) {
            combinationDFS(order + orders.charAt(o), orders.substring(o + 1), count - 1);
        }
    }
    private static List<String> solution(String[] orders, int[] course) {
        for(int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for(int c : course) {
            for(String order : orders)
                combinationDFS("", order, c);

            if (!countOfOrdered.isEmpty()) {
                List<Integer> countList = new ArrayList<>(countOfOrdered.values());
                int max = Collections.max(countList);

                if (max > 1) {
                    for(String key : countOfOrdered.keySet()) {
                        if (countOfOrdered.get(key) == max) { answer.add(key); }
                    }
                }
                countOfOrdered.clear();
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};
        solution(orders, course);
    }
}
