package CodingTest.KaKao.Internship2021.NumericStrings_EngWords;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Solution(sc.nextLine()));
    }
    public static int Solution(String s) {
        s= s.replaceAll("zero", "0");
        s= s.replaceAll("one", "1");
        s= s.replaceAll("two", "2");
        s= s.replaceAll("three", "3");
        s= s.replaceAll("four", "4");
        s= s.replaceAll("five", "5");
        s= s.replaceAll("six", "6");
        s= s.replaceAll("seven", "7");
        s= s.replaceAll("eight", "8");
        s= s.replaceAll("nine", "9");

        return Integer.parseInt(s);
    }
}