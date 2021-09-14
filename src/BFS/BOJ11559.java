package BFS;

import java.util.*;

/**
 * 1. 입력받은 필드를 탐색하며 뿌요가 있는 필드에 도달하면 그 근처에 같은 색의 뿌요가 몇개 있는지 BFS 알고리즘을 통해 탐색한다.
 * 2. 같은 색의 뿌요가 4개 이상이라면 해당 뿌요들을 연쇄시킨다.
 * 3. 연쇄가 일어났다면 뿌요들을 아래로 떨어뜨리고 연속연쇄 수를 하나 늘려준다. 연쇄가 일어나지 않았다면 탐색을 종료한다.
 */

public class BOJ11559 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static List<Puyo> list;

    // 뿌요의 위치값 정보를 가진 클래스
    public static class Puyo {
        int row; int col;

        public Puyo(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    //뿌요 터뜨린 후 밑으로 내려주기
    static void fall(char[][] board) {
        for (int i = 0; i < 6; i++) {
            for (int j = 11; j > 0; j--) {
                if (board[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[k][i] != '.') {
                            board[j][i] = board[k][i];
                            board[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    // 터뜨릴 뿌요 BFS 탐색
    public static void bfs(char[][] board, int x, int y) {
        Queue<Puyo> queue = new LinkedList<>();
        queue.offer(new Puyo(x, y));
        list.add(new Puyo(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Puyo now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.row + dx[i];
                int ny = now.col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 12 && ny < 6 && // 범위 체크
                        visited[nx][ny] == false && board[nx][ny] == board[x][y]) {
                    visited[nx][ny] = true;
                    list.add(new Puyo(nx, ny));
                    queue.offer(new Puyo(nx, ny));
                }
            }
        }
    }
    public static int solution(char[][] board) {
        int answer = 0;

        //board 탐색하며 상하좌우 4개 이상인 뿌요 찾기
        while (true) {
            boolean cascade = false;
            visited = new boolean[12][6];

            for(int i = 0; i < 12; i++) {
                for(int j = 0; j < 6; j++) {
                    // 뿌요일 경우
                    if(board[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(board, i, j);
                        // 연쇄 가능성 체크
                        if(list.size() >= 4) {
                            cascade = true;
                            for (int k = 0; k < list.size(); k++)
                                board[list.get(k).row][list.get(k).col] = '.'; // 터뜨리기
                        }
                    }
                }
            }
            if(!cascade) break; // 연쇄가 없으면 반복문 종료
            fall(board); // 뿌요 떨어뜨리기
            answer += 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 필드 정보 입력
        char[][] board = new char[12][6];
        for(int i = 0; i < 12; i++) {
            String field = sc.nextLine();
            for(int j = 0; j < 6; j++) {
                board[i][j] = field.charAt(j);
            }
        }

        System.out.println(solution(board));
    }
}
