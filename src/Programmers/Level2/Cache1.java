package Programmers.Level2;

import java.util.LinkedList;

public class Cache1 {
    private static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) return 5 * cities.length;

        LinkedList<String> cache = new LinkedList<>();
        for(String city : cities) {
            city = city.toLowerCase();
            // Cache Hit
            if (cache.contains(city)) {
                cache.remove(cache.indexOf(city));
                cache.addFirst(city);
                answer += 1;
            // Cache Miss
            } else {
                if (cache.size() == cacheSize) {
                    cache.pollLast();
                }
                cache.addFirst(city);
                answer += 5;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int cacheSize = 5;
        String[] cities = {"SEOUL", "SEOUL", "SEOUL"};
        System.out.println(solution(cacheSize, cities));
    }
}
