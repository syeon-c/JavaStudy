package Programmers.Level3;

import java.util.Arrays;
import java.util.HashSet;

public class BadUser {
    static HashSet<String> ban;
    static boolean[] visited;
    private static int solution(String[] user_id, String[] banned_id) {
        ban = new HashSet<>();
        for(int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }
        visited = new boolean[user_id.length];
        getBannedId_dfs(0, "", user_id, banned_id);

        return ban.size();
    }

    private static void getBannedId_dfs(int index, String result, String[] user_id, String[] banned_id) {
        if (index == banned_id.length) {
            // 정렬 위해 배열화 -> 문자열 변환 후 해쉬셋에 추가
            String[] idArr = result.split(" ");
            Arrays.sort(idArr);
            String res = "";
            for(String id : idArr) {
                res += id;
            }
            ban.add(res);
            return;
        }
        for(int i = 0; i < user_id.length; i++) {
            if (!visited[i] && user_id[i].matches(banned_id[index])) {
                visited[i] = true;
                getBannedId_dfs(index + 1, result + " " + user_id[i], user_id, banned_id);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};
        System.out.println(solution(user_id, banned_id));
    }
}
