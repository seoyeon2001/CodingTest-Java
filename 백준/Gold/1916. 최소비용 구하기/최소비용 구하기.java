import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[s].add(new int[] {e, cost});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        answer[start] = 0;
        pq.add(new int[] {start, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(cur[1] > answer[cur[0]]) continue;

            for(int[] next : list[cur[0]]) {
                if(answer[cur[0]] + next[1] < answer[next[0]]) {
                    answer[next[0]] = answer[cur[0]] + next[1];
                    pq.add(new int[] {next[0], answer[next[0]]});
                }
            }
        }

        System.out.println(answer[end]);
    }
}
