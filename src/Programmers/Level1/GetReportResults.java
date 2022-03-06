package Programmers.Level1;

import java.util.*;

/**
 * 프로그래머스/Lv1/신고 결과 받기
 * 신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.
 *
 *  - 각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
 *      - 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
 *      - 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
 *
 *  - k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
 *      - 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
 *
 * 이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report, 정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때,
 * 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

public class GetReportResults {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> reported = new HashMap<>();
        Map<String, ArrayList<String>> report_list = new HashMap<>();

        for(String rep : report) {
            String[] content = rep.split(" ");
            String fromId = content[0];
            String toId = content[1];
            boolean alreadyReported = false;
            if (report_list.containsKey(fromId)) {
                if (report_list.get(fromId).contains(toId))
                    alreadyReported = true;
                else {
                    ArrayList<String> tmp = report_list.get(fromId);
                    tmp.add(toId);
                    report_list.put(fromId, tmp);
                }
            } else {
                report_list.put(fromId,new ArrayList(Arrays.asList(toId)));
            }
            if (!alreadyReported) reported.put(toId, reported.getOrDefault(toId, 0) + 1);
        }

        for(int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            if (report_list.containsKey(id)) {
                for(String reportId : report_list.get(id)) {
                    if (reported.get(reportId) >= k) answer[i]++;
                }
            } else answer[i] = 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        for(int a : solution(id_list, report, k)) {
            System.out.print(a + " ");
        }
    }
}
