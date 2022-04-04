package Programmers.Level2;

public class TakeGroupPhoto {
    static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static int answer = 0;

    private static void dfs(String names, boolean[] visit, String[] data) {
        if (names.length() == 8) {
            if(conditionCheck(names, data)) answer++;
            return;
        }
        for(int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                String name = names + friends[i];
                dfs(name, visit, data);
                visit[i] = false;
            }
        }
    }
    private static boolean conditionCheck(String names, String[] data) {
        for(String d : data) {
            int pos1 = names.indexOf(d.charAt(0));
            int pos2 = names.indexOf(d.charAt(2));
            char op = d.charAt(3);
            int distance = d.charAt(4) - '0';

            if (op == '=') {
                if (Math.abs(pos1 - pos2) != distance+1) return false;
            } else if (op == '>') {
                if (!(Math.abs(pos1 - pos2) > distance+1)) return false;
            } else {
                if (!(Math.abs(pos1 - pos2) < distance+1)) return false;
            }
        }
        return true;
    }
    private static int solution(int n, String[] data) {
        boolean[] visited = new boolean[8];
        answer = 0;
        dfs("", visited, data);
        return answer;
    }
    public static void main(String[] args) {
        int n = 2;
        String[] data = {"M~C<2", "C~M>1"};
        System.out.println(solution(n, data));
    }
}
