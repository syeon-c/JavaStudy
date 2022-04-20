package Programmers.Level2;

import java.util.ArrayList;

public class MaximizeFormula {
    public static long solution(String expression) {
        long answer = Long.MIN_VALUE;
        // 모든 연산자 우선순위
        String op[][] = {
                { "+", "-", "*" },
                { "+", "*", "-" },
                { "-", "*", "+" },
                { "-", "+", "*" },
                { "*", "-", "+" },
                { "*", "+", "-" }
        };
        // 숫자와 연산자 분리해서 list 추가
        ArrayList<String> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                list.add(expression.substring(start, i)); // 연산자 앞 숫자 추가
                list.add(expression.charAt(i) + ""); // 연산자 추가
                start = i + 1;
            }
        }
        list.add(expression.substring(start)); // 마지막 숫자 추가

        // 연산자 우선순위 6개의 경우에 대한 계산 진행
        // 완전 탐색
        for(int i = 0; i < op.length; i++) {
            ArrayList<String> copyList = new ArrayList<>(list);
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < copyList.size(); k++) {
                    if (op[i][j].equals(copyList.get(k))) {
                        copyList.set(k - 1, calculate(copyList.get(k - 1), copyList.get(k), copyList.get(k + 1)));
                        copyList.remove(k);
                        copyList.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(copyList.get(0))));
        }

        return answer;
    }

    private static String calculate(String num1, String op, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);

        if (op.equals("+"))
            return n1 + n2 + "";
        else if (op.equals("-"))
            return n1 - n2 + "";
        else
            return n1 * n2 + "";
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }
}
