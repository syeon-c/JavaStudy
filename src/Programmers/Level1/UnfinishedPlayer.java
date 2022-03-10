package Programmers.Level1;

import java.util.HashMap;

public class UnfinishedPlayer {
    private static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> player = new HashMap<>();
        for(String c : completion) {
            player.put(c, player.getOrDefault(c, 0) + 1);
        }
        for(String p : participant) {
            if (player.containsKey(p)) {
                if (player.get(p) == 0) {
                    answer = p;
                    break;
                } else player.replace(p, player.get(p) - 1);
            } else {
                answer = p;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] participant = {};
        String[] completion = {};
        System.out.println(solution(participant, completion));
    }
}
