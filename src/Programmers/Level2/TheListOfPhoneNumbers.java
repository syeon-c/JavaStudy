package Programmers.Level2;

import java.util.Arrays;

public class TheListOfPhoneNumbers {
    private static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] phone_book = {"123", "1234", "1235"};
        System.out.println(solution(phone_book));
    }
}
