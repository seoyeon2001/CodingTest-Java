import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<int[]>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int[] {b, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        PriorityQueue<Integer>[] answer = new PriorityQueue[n+1];
        for(int i = 1; i <= n; i++) {
            answer[i] = new PriorityQueue<>((a, b) -> b - a);
        }

        // 1 시작
        pq.add(new int[] {1, 0});
        answer[1].add(0);

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];

            for(int[] next : list[curNode]) {
                int nextNode = next[0];
                int nextDist = next[1];

                if(answer[nextNode].size() == k) {
                    if(answer[nextNode].peek() > nextDist + curDist) {
                        answer[nextNode].poll();
                        answer[nextNode].add(nextDist + curDist);
                        pq.add(new int[] {nextNode, nextDist + curDist});
                    }
                }
                else {
                    answer[nextNode].add(nextDist + curDist);
                    pq.add(new int[] {nextNode, nextDist + curDist});
                }
            }
        }      

        for(int i = 1; i <= n; i++) {
            if(answer[i].size() != k) {
                System.out.println(-1);
            } else {
                System.out.println(answer[i].peek());
            }
        }

    }
}
