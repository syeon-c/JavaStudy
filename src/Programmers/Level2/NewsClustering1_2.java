package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class NewsClustering1_2 {
    private static List<String> setList(String str) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < str.length() - 1; i++) {
            String tmp = "";
            if (Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
                tmp += Character.toUpperCase(str.charAt(i));
                tmp += Character.toUpperCase(str.charAt(i+1));
                list.add(tmp);
            }
        }
        return list;
    }
    private static int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>(setList(str1));
        List<String> list2 = new ArrayList<>(setList(str2));

        if (list1.size() == 0 && list2.size() == 0) return 65536;

        List<String> intersection = new ArrayList<>();
        List<String> copy1 = new ArrayList<>(list1);
        List<String> copy2 = new ArrayList<>(list2);

        for(String str : list1) {
            if (copy2.contains(str)) {
                intersection.add(str);
                copy1.remove(str);
                copy2.remove(str);
            }
        }
        int n_size = intersection.size();
        int u_size = n_size + copy1.size() + copy2.size();

        return (int)(((double) n_size / u_size) * 65536);
    }
    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(solution(str1, str2));
    }
}
