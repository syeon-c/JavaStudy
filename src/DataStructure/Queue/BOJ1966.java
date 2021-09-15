package DataStructure.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1966 {
    public static class Q {
        int position; int value; int out;

        public Q(int position, int value) {
            this.position = position;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            List<Q> list = new LinkedList<>();
            Q result = null;

            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                Q q = new Q(i, v);
                list.add(q);
                if(pos == i) result = q;
            }

            int answer = 1;
            while(!list.isEmpty()) {
                int p = list.get(0).value;

                for(int i = 0; i < list.size(); i++) {
                    if(list.get(i).value > p) {
                        list.add(list.get(0));
                        list.remove(0);
                        break;
                    }

                    if(i == list.size() - 1) {  // 나보다 우선되는 work 없다면
                        list.get(0).out = answer++;
                        list.remove(0);
                    }
                }
            }
            System.out.println(result.out);
        }
    }
}
