package Programmers.Level2;

public class Friends4Block {
    private static char[][] map;
    private static int solution(int m, int n, String[] board) {
        int answer = 0;
        // 게임 맵 설정
        map = new char[m][n];
        for(int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        while (true) {
            int cnt = checkBlock(m, n);
            if (cnt == 0) break;
            answer += cnt;
            dropBlock(m, n);
        }
        return answer;
    }

    private static void dropBlock (int m, int n) {
        for(int i = m - 1; i > 0; i--) {
            for(int j = 0; j < n; j++) {
                if (map[i][j] == '0') {
                    // 지워질 블록 위치 기준 아래에서부터 블록 이동
                    for(int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != '0') {
                            map[i][j] = map[k][j];
                            map[k][j] = '0';
                            break;
                        }
                    }
                }
            }
        }

    }

    private static int checkBlock(int m, int n) {
        boolean[][] checkBlockCanPop = new boolean[m][n];
        for(int i = 0; i < m-1; i++) {
            for(int j = 0; j < n-1; j++) {
                char cur = map[i][j];
                if (cur != '0') {
                    if (cur == map[i + 1][j] && cur == map[i][j + 1] && cur == map[i + 1][j + 1]) {
                        checkBlockCanPop[i][j] = true;
                        checkBlockCanPop[i + 1][j] = true;
                        checkBlockCanPop[i][j + 1] = true;
                        checkBlockCanPop[i + 1][j + 1] = true;
                    }
                }
            }
        }
        return countBlock(m, n, checkBlockCanPop);
    }

    private static int countBlock(int m, int n, boolean[][] checkBlockCanPop) {
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(checkBlockCanPop[i][j]) {
                    count++;
                    map[i][j] = '0';
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 8;
        int n = 5;
        String[] board = {"HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK"};
        System.out.println(solution(m, n, board));
    }
}
