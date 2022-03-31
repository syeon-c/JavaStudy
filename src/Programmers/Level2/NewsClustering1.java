package Programmers.Level2;

import java.util.ArrayList;

public class NewsClustering1 {
    private static int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        setList(str1, list1);
        setList(str2, list2);

        // 공집합 예외처리
        if (list1.size() == 0 && list2.size() == 0) return 65536;

        ArrayList<String> nList = new ArrayList<>();
        ArrayList<String> copy1 = new ArrayList<>(list1);
        ArrayList<String> copy2 = new ArrayList<>(list2);

        for (String str : list1) {
            if (copy2.contains(str)) {
                nList.add(str);
                copy1.remove(str);
                copy2.remove(str);
            }
        }

        int n = nList.size();
        int u = n + (copy1.size()) + (copy2.size());

        return (int) (((double) n / u) * 65536);
    }

    private static void setList(String str1, ArrayList<String> list1) {
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = "";
            if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) {
                tmp += Character.toUpperCase(str1.charAt(i));
                tmp += Character.toUpperCase(str1.charAt(i + 1));
                list1.add(tmp);
            }
        }
    }

    public static void main(String[] args) {
        String str1 = "aaaa+bbb";
        String str2 = "aaa+bbbb";
        System.out.println(solution(str1, str2));
    }
}
