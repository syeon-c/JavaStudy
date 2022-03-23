package String;

import javax.imageio.stream.IIOByteBuffer;

public class P01 {
    private static String Solution(String character, String[] monsters) {
        String answer = "";
        int get_max = -1;
        String[] ch = character.split(" ");
        for(String m : monsters) {
            boolean win = true;
            int time = 0;
            int p_hp = Integer.parseInt(ch[0]);
            String[] monster = m.split(" ");
            String m_name = monster[0];
            int m_point = Integer.parseInt(monster[1]);
            int m_hp = Integer.parseInt(monster[2]);
            int m_power = Integer.parseInt(monster[3]);
            int m_shield = Integer.parseInt(monster[4]);

            while (true) {
                m_hp -= (Integer.parseInt(ch[1]) - m_shield);
                time++;
                if (m_hp <= 0) break;
                p_hp -= (m_power - Integer.parseInt(ch[2]));
                if (p_hp <= 0) {
                    win = false;
                    break;                }
                p_hp = Integer.parseInt(ch[0]);
            }
            if (win) {
                int get = m_point / time;
                if (get > get_max) {
                    answer = m_name;
                    get_max = get;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String character = "10 5 2";
        String[] monsters = {"Knight 3 10 10 3","Wizard 5 10 15 1","Beginner 1 1 15 1"};
        System.out.println(Solution(character, monsters));
    }
}
