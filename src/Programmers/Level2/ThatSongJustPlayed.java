package Programmers.Level2;

public class ThatSongJustPlayed {
    private static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        // #과 구분하기 위해 멜로디 변환
        m = changeMelody(m);
        int longestPlayTime = -1;
        for(String musicInfo : musicinfos) {
            String[] info = musicInfo.split(",");
            // 시작시간과 종료시간 분 단위로 변환
            String[] startTime = info[0].split(":");
            int start = Integer.valueOf(startTime[0]) * 60 + Integer.valueOf(startTime[1]);
            String[] endTime = info[1].split(":");
            int end = Integer.valueOf(endTime[0]) * 60 + Integer.valueOf(endTime[1]);
            int playTime = end - start;

            String title = info[2];
            String melody = changeMelody(info[3]);

            if (playTime > melody.length()) {
                StringBuilder played = new StringBuilder();
                for(int i = 0; i < playTime; i++) {
                    played.append(melody.charAt(i % melody.length()));
                }
                melody = played.toString();
            } else {
                melody = melody.substring(0, playTime);
            }
            // 조건이 일치하는 음악이 여러 개라면 재생 시간 비교 > 더 긴 음악 반환
            if (melody.contains(m) && playTime > longestPlayTime) {
                answer = title;
                longestPlayTime = playTime;
            }
        }
        return answer;
    }

    private static String changeMelody(String melody) {
        melody = melody.replaceAll("C#", "H");
        melody = melody.replaceAll("D#", "I");
        melody = melody.replaceAll("F#", "J");
        melody = melody.replaceAll("G#", "K");
        String newMelody = melody.replaceAll("A#", "L");
        return newMelody;
    }

    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicInfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicInfos));
    }
}
