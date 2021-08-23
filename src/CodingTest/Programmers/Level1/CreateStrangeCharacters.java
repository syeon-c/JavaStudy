package CodingTest.Programmers.Level1;

import java.util.Locale;

public class CreateStrangeCharacters {
    public static void main(String[] args) {
        String s = "try hello world";
        System.out.println(Solution(s));

    }

    public static String Solution(String s) {
        String answer = "";
        String[] sList = s.split(" ", -1);

        for(int i = 0; i < sList.length; i++) {
            String[] tmp = sList[i].split("");
            for(int j = 0; j < sList[i].length(); j++) {
                if(j % 2 == 0) {
                    answer += tmp[j].toUpperCase();
                } else {
                    answer += tmp[j].toLowerCase();
                }
            }
            answer += " ";
        }

        return answer.substring(0,answer.length()-1);
    }
}
