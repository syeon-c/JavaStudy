package String;
/**
 * 가장 짧은 문자 거리
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출 력하는 프로그램을 작성하세요.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String10 {
    private static void Solution(String s, char t) {
        int[] answer = new int[s.length()];
        int d = 100;
        /** index 0 부터 끝까지 탐색, 왼쪽에 위치한 t와 가까운 거리 구하기*/
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t) {
                d = 0;
                answer[i] = d;
            } else {
                d++;
                answer[i] = d;
            }
        }
        d = 100;
        /** index -1부터 재탐색, 오른쪽에 위치한 t와 가까운 거리 구하기*/
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == t) {
                d = 0;
            } else {
                d++;
                /** 왼쪽에 위치한 t와 오른쪽에 위치한 t와의 거리 중 가까운 값으로 설정*/
                answer[i] = Math.min(answer[i], d);
            }
        }
        for(int a  : answer) {
            System.out.print(a + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        br.close();
        String s = input[0];
        char t = input[1].charAt(0);
        Solution(s, t);
    }
}
