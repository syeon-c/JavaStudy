package Programmers.Level2;

import java.util.ArrayList;
import java.util.Stack;

public class BracketTransformation {
    private static String solution(String p) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> isRight = new Stack<>();
        ArrayList<Character> list = new ArrayList<>();
        int index = 0;

        if (p.length() == 0) return p;

        int openCount = 0;
        int closeCount = 0;

        for(int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') openCount++;
            if (p.charAt(i) == ')') closeCount++;
            list.add(p.charAt(i));
            isRight.add(p.charAt(i));

            // 올바른 괄호 문자열 검사하기
            if(isRight.size() >= 2) {
                while(true) {
                    if(isRight.get(isRight.size()-1)==')' && isRight.get(isRight.size()-2)=='(') {
                        isRight.pop();
                        isRight.pop();
                    } else {
                        break;
                    }
                    if(isRight.size()==0) {
                        break;
                    }
                }
            }

            // 만약 '('의 개수와 ')' 개수가 동일하다면(균형잡힌 괄호 문자열)  -> 2번 과정
            if (openCount == closeCount) {
                index = i;
                // 만약 p 문자열이 올바른 괄호 문자열이 아닐경우 4번과정
                if(isRight.size()!=0) {
                    //4-1
                    sb.append('(');
                    //4-2
                    sb.append(solution(p.substring(index + 1)));
                    //4-3
                    sb.append(')');
                    //4-4
                    list.remove(list.size()-1);
                    list.remove(0);
                    for(int j = 0; j < list.size(); j++) {
                        if(list.get(j)=='(') {
                            list.set(j, ')');
                        } else if(list.get(j)==')') {
                            list.set(j, '(');
                        }
                    }
                    //4-5
                    for(char ch : list) { sb.append(ch); }
                    return sb.toString();
                }
                break;
            }
        }
        // 만약 p 문자열이 올바른 괄호 문자열인 경우 3-1 과정
        for (char ch : list) {
            sb.append(ch);
        }
        return sb.toString() + solution(p.substring(index + 1));
    }
    public static void main(String[] args) {
        String p = "()))((()";
        System.out.println(solution(p));
    }
}
