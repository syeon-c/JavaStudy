package Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class SkillTree {
    private static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Character> skill_order = new ArrayList<>();
        for(Character c : skill.toCharArray()) {
            skill_order.add(c);
        }

        for(String s : skill_trees) {
            boolean canLearn = true;
            int index = 0;
            for(Character c : s.toCharArray()) {
                if (skill_order.contains(c)) {
                    if(c == skill_order.get(index)) index++;
                    else {
                        canLearn = false;
                        break;
                    }
                }
            }
            if (canLearn) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }
}
