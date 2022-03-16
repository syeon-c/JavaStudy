package Programmers.Level1;

import java.util.*;

/**
 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
 * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return
 * rule1 : 실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 * rule2 : 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 옴
 * rule3 : 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의
 */

public class FailureRate {
    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(solution(n, stages));
    }
    public static List<Integer> solution(int n, int[] stages) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Double> failure = new HashMap<>();
        int user = stages.length;


        return answer;
    }
}
