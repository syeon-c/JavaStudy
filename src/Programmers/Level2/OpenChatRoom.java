package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 프로그래머스/lv2/오픈채팅방
 *
 * 채팅방에 누군가 들어오면 다음 메시지가 출력된다.
 * "[닉네임]님이 들어왔습니다."
 *
 * 채팅방에서 누군가 나가면 다음 메시지가 출력된다.
 * "[닉네임]님이 나갔습니다."
 *
 * 채팅방에서 닉네임을 변경하는 방법은 다음과 같이 두 가지이다.
 * 채팅방을 나간 후, 새로운 닉네임으로 다시 들어간다.
 * 채팅방에서 닉네임을 변경한다.
 *
 * 닉네임을 변경할 때는 기존에 채팅방에 출력되어 있던 메시지의 닉네임도 전부 변경된다.
 */

public class OpenChatRoom {
    private static List<String> solution2(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> userInfo = new HashMap<>();
        HashMap<String, String> order = new HashMap<>();
        order.put("Enter", "님이 들어왔습니다.");
        order.put("Leave", "님이 나갔습니다.");

        // 유저 정보 설정
        for(String rec : record) {
            String[] message = rec.split(" ");
            if (message[0].equals("Enter") || message[0].equals("Change"))
                userInfo.put(message[1], message[2]);
        }

        for(String r : record) {
            String[] message = r.split(" ");
            if (message[0].equals("Enter") || message[0].equals("Leave")) {
                String tmp = "";
                tmp += userInfo.get(message[1]);
                tmp += order.get(message[0]);
                answer.add(tmp);
            }
        }
        return answer;
    }
    private static List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> idInfo = new HashMap<>();

        for(String r : record) {
            String[] message = r.split(" ");
            if (message[0].equals("Change")) {
                idInfo.replace(message[1], message[2]);
            }
            else if (message[0].equals("Enter")) {
                idInfo.put(message[1], message[2]);
            }
        }

        for(String r : record) {
            String[] message = r.split(" ");
            if (!idInfo.containsKey(message[1])) {
                idInfo.put(message[1], message[2]);
            }
            if (message[0].equals("Enter")) {
                answer.add(idInfo.get(message[1]) + "님이 들어왔습니다.");
            } else if (message[0].equals("Leave")) {
                answer.add(idInfo.get(message[1]) + "님이 나갔습니다.");
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        for(String s : solution2(record)) {
            System.out.println(s);
        }
    }
}
