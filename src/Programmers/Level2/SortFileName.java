package Programmers.Level2;

/**
 * https://subin-0320.tistory.com/103
 * Comparator 이용한 정렬 조건 설정
 */

import java.util.Arrays;
import java.util.Comparator;

public class SortFileName {
    private static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 숫자를 기준으로 잘라서 앞 부분 헤드 설정
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                // 같은 문자일 경우 숫자로 비교
                if (result == 0) {
                    result = sortNum(o1, head1) - sortNum(o2, head2);
                }
                return result;
            }
        });
        return files;
    }

    private static int sortNum(String file, String head) {
        // head 길이 잘라내기
        file = file.substring(head.length());
        String number = "";
        for(char n : file.toCharArray()) {
            if (Character.isDigit(n) && number.length() < 5) {
                number += n;
            } else break;
        }
        return Integer.valueOf(number);
    }

    public static void main(String[] args) {

    }
}
