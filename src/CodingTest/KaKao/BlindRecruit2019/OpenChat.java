package CodingTest.KaKao.BlindRecruit2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChat {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(record));
    }

    public static List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> memory = new HashMap<>();

        for(String r : record) {
            String[] keyword = r.split(" ");

            if(keyword[0].equals("Change")) {
                memory.replace(keyword[1], keyword[2]);
            } else if(keyword[0].equals("Enter")) {
                memory.put(keyword[1], keyword[2]);
            }

        }

        for(String r : record) {
            String[] keyword = r.split(" ");

            if(!memory.containsKey(keyword[1])) {
                memory.put(keyword[1], keyword[2]);
            }

            String str = "";

            if(keyword[0].equals("Enter")) {
                str += memory.get(keyword[1]) + "님이 들어왔습니다.";
                answer.add(str);
            } else if(keyword[0].equals("Leave")) {
                str += memory.get(keyword[1]) + "님이 나갔습니다.";
                answer.add(str);
            }



        }
        return answer;
    }
}
