package Programmers.Level2;

/**
 * https://geunzrial.tistory.com/162?category=872210
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeStarVertex {
    private static List<String> solution(int[][] line) {
        // 정수로 표현되는 교점 리스트
        List<List<Integer>> list = new ArrayList<>();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        // 1. 교점 구하기
        for(int i = 0; i < line.length - 1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for(int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long parent = (a * d) - (b * c);

                if (parent == 0) continue;

                long xChild = (b * f) - (e * d);
                long yChild = (e * c) - (a * f);

                if (xChild % parent != 0 || yChild % parent % parent != 0) continue;

                int x = (int) (xChild/parent);
                int y = (int) (yChild/parent);
                List<Integer> intersectionPoint = Arrays.asList(x,y);
                // 중복 제거
                if(!list.contains(intersectionPoint)){
                    list.add(intersectionPoint);
                }
                // 2. 교점 이용해 x, y의 최대 최소 구하기
                minX = Math.min(x,minX);
                minY = Math.min(y,minY);
                maxX = Math.max(x,maxX);
                maxY = Math.max(y,maxY);
            }
        }
        // 3. x, y 이용해 '.' , '*' 입력
        List<String> board = new ArrayList<>();
        for(int i = minY; i <= maxY; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = minX; j <= maxX; j++){
                sb.append(".");
            }
            board.add(sb.toString());
        }

        for(List<Integer> point : list){
            StringBuilder sb = new StringBuilder(board.get(Math.abs(point.get(1) - maxY)));
            // '*' 로 바꿔주고 line 재설성
            sb.setCharAt(Math.abs(point.get(0) - minX),'*');
            board.set(Math.abs(point.get(1) - maxY),sb.toString());
        }

        return board;
    }
    public static void main(String[] args) {
        int[][] line = {{2,-1,4},{-2,-1,4},{0,-1,1},{5,-8,-12},{5,8,12}};
        for(String s : solution(line)) {
            System.out.println(s);
        }
    }
}
