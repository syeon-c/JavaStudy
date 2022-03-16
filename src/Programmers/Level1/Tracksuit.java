package Programmers.Level1;

import java.util.Arrays;

public class Tracksuit {
    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 여벌 체육복을 가져온 학생이 도난 당한 경우
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {

                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        // 도난 당한 학생에게 체육복 빌려주기
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if (lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(solution(n, lost, reserve));
    }
}
