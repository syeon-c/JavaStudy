package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class LengthofVisit {
    private static class Position {
        int x;
        int y;
        int dx;
        int dy;

        public Position(int x, int y, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }

        public String getStr() {
            String str = "";
            str += x;
            str += y;
            str += dx;
            str += dy;
            return str;
        }
    }
    private static int solution(String dirs) {
        int answer = 0;
        Set<String> visited = new HashSet<>();
        Position position = new Position(0, 0, 0, 0);
        for(char dir : dirs.toCharArray()) {
            switch (dir) {
                case 'U':
                    if (position.y + 1 <= 5) {
                        position.y += 1;
                        position.dx = 0;
                        position.dy = -1;
                    }
                    break;
                case 'D':
                    if (position.y - 1 >= -5) {
                        position.y -= 1;
                        position.dx = 0;
                        position.dy = 1;
                    }
                    break;
                case 'R':
                    if (position.x + 1 <= 5) {
                        position.x += 1;
                        position.dx = -1;
                        position.dy = 0;
                    }
                    break;
                case 'L':
                    if (position.x - 1 >= -5) {
                        position.x -= 1;
                        position.dx = 1;
                        position.dy = 0;
                    }
                    break;
            }
            if (!visited.contains(position.getStr())) {
                visited.add(position.getStr());
                Position opposite_pos = new Position(position.x + position.dx, position.y + position.dy, position.dx * -1, position.dy * -1);
                visited.add(opposite_pos.getStr());
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        System.out.println(solution(dirs));
    }
}
