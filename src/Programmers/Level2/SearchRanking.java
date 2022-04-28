package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://www.youtube.com/watch?v=vFwVvJQnC4M
 * Hash + BinarySearch 활용
 *  1) info 기반으로 해쉬맵 정보 생성
 *  2) query 처리 > query 조건에 맞는 지원자들 점수 가져오기
 *  3) 이분탐색 통해 기준 점수 이상인 지원자 세기
 */
public class SearchRanking {
    private static int[] solution(String[] info, String[] query) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        // 1. info 기반 HashMap 생성
        for(String i : info) {
            String[] data = i.split(" ");
            String[] languages = {data[0], "-"};
            String[] jobs = {data[1], "-"};
            String[] careers = {data[2], "-"};
            String[] foods = {data[3], "-"};
            int score = Integer.parseInt(data[4]);
            // map 생성
            for(String language : languages)
                for(String job : jobs)
                    for(String career : careers)
                        for(String food : foods) {
                            // key 값에 대해 배열 생성 후 조합
                            String[] keyData = {language, job, career, food};
                            String key = String.join(" ", keyData);
                            // map에 key 값이 있으면 해당 값 가져오고 아니면 빈 배열 입력
                            ArrayList<Integer> arr = map.getOrDefault(key, new ArrayList<>());
                            arr.add(score);
                            map.put(key, arr);
                        }
        }
        // 2. 각 해쉬맵 정보의 value 오름차순 정렬
        for(ArrayList<Integer> arr : map.values()) {
            arr.sort(null);
        }
        // 3. query 조건에 맞는 지원자 가져오기
        int[] answer = new int[query.length];
        int index = 0;
        for(String q : query) {
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data);

            if (map.containsKey(key)) {
                ArrayList<Integer> list = map.get(key);
                // 4. Binary Search 통해 lower-bound 찾기
                int left = 0;
                int right = list.size();
                left = binarySearch(target, list, left, right);
                answer[index] = list.size() - left;
            }
            index++;
        }
        return answer;
    }

    private static int binarySearch(int target, ArrayList<Integer> list, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) {
                right = mid;
            } else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        System.out.println(solution(info, query));
    }
}
