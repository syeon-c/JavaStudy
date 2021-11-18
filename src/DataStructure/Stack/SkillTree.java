package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SkillTree {
    private static void Solution(String skill, List<String> skill_trees) {
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
        System.out.println(answer);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String skill = br.readLine();
        List<String> skill_trees = new ArrayList<>();
        String[] skills = br.readLine().split(" ");
        for(String s : skills)
            skill_trees.add(s);
        br.close();
        Solution(skill, skill_trees);
    }
}
