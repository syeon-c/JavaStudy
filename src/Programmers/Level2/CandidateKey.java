package Programmers.Level2;

import java.util.*;

public class CandidateKey {
    private static List<String> candidateList = new ArrayList<>();

    private static int solution(String[][] relation) {
        for(int i = 0; i < relation[0].length; i++) {
            boolean[] visited = new boolean[relation[0].length];
            keyCombination(visited, 0, 0, i + 1, relation);
        }
        return candidateList.size();
    }

    private static void keyCombination(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            List<Integer> keyIndexList = new ArrayList<>();
            String key = "";
            for(int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    keyIndexList.add(i);
                }
            }

            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < relation.length; i++) {
                String s = "";
                for (Integer j : keyIndexList) {
                    s += relation[i][j];
                }

                if (map.containsKey(s)) {
                    return;
                } else {
                    map.put(s, 0);
                }
            }

            // 후보키 추가
            for (String s : candidateList) {
                int count = 0;
                for(int i = 0; i < key.length(); i++){
                    String subS = String.valueOf(key.charAt(i));
                    if(s.contains(subS)) count++;
                }
                if (count == s.length()) return;
            }
            candidateList.add(key);

            return;
        }

        for(int i = start; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                keyCombination(visited, i, depth + 1, end, relation);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        System.out.println(solution(relation));
    }
}
