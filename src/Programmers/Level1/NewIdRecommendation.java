package Programmers.Level1;

/**
 * 프로그래머스/Lv1/신규 아이디 추천
 *
 * 카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어, 카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다.
 * "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
 * 다음은 카카오 아이디의 규칙입니다.
 *
 *  - 아이디의 길이는 3자 이상 15자 이하여야 합니다.
 *  - 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
 *  - 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
 *
 * "네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해 신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고 규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.
 */

public class NewIdRecommendation {
    private static String solution(String new_id) {
        String answer = "";
        // 1단계 : 대문자 -> 소문자
        // 2단계 : 소문자, -, _, ., 을 제외한 모든 문자 제거
        for(char c : new_id.toCharArray()) {
            if (Character.isAlphabetic(c))
                answer += Character.toLowerCase(c);
            else if (c == '_' || c == '-' || c == '.' || Character.isDigit(c))
                answer += c;
            else continue;
        }
        // 3단계 : 마침표 두 개 이상 연속 -> 하나로 치환
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }
        // 4단계 : 마침표 처음이나 끝에 위치한다면 제거
        if (answer.startsWith(".")) answer = answer.substring(1, answer.length());
        if (answer.endsWith(".")) answer = answer.substring(0, answer.length() - 1);

        // 5단계 : 빈 문자열이면 "a" 대입
        if (answer.length() == 0) answer += "a";

        // 6단계 : 길이가 16 이상이면 첫 15개 제외한 나머지 문자 제거
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            while (answer.endsWith(".")) answer = answer.substring(0, answer.length() - 1);
        }
        // 7단계 : 길이가 2자 이하면 마지막 문자 길이가 3 될 때까지 반복해서 끝에 추가
        if (answer.length() <= 2) {
            while (answer.length() < 3) answer += answer.charAt(answer.length() - 1);
        }
        return answer;
    }
    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";
        System.out.println(solution(new_id));
    }
}
