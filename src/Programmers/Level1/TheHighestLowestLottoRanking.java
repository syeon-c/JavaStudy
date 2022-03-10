package Programmers.Level1;

import java.util.ArrayList;
import java.util.Map;

/**
 * 프로그래머스/Lv1/로또의 최고 순위와 최저 순위
 *
 * 로또는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다. 아래는 로또의 순위를 정하는 방식입니다.
 *
 *  순위	        당첨 내용
 *  1	    6개 번호가 모두 일치
 *  2	    5개 번호가 일치
 *  3	    4개 번호가 일치
 *  4	    3개 번호가 일치
 *  5	    2개 번호가 일치
 *  6(낙첨)	    그 외
 *
 * 로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다.
 * 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다.
 * 당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
 * 민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
 * 이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 */

public class TheHighestLowestLottoRanking {
    static Map<Integer, Integer> rank = Map.of(
            6, 1,
            5, 2,
            4, 3,
            3, 4,
            2, 5,
            1, 6,
            0, 6
    );
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int win = 0;
        int probability = 0;
        ArrayList<Integer> win_nums_list = new ArrayList<>();
        for(int wn : win_nums) { win_nums_list.add(wn); }

        for(int num : lottos) {
            if (win_nums_list.contains(num)) win++;
            else if (num == 0) probability++;
        }

        if (win + probability > 6) {
            probability = 6;
        } else probability = win + probability;

        answer[0] = rank.get(probability);
        answer[1] = rank.get(win);

        return answer;
    }

    public static void main(String[] args) {

    }
}
