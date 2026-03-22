import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        List<int[]>[] list = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new int[] {v, w});
        }

        boolean[] visited = new boolean[V+1];
        int[] answer = new int[V+1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 시작
        answer[K] = 0;
        q.add(new int[] {K, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(visited[cur[0]]) continue;

            visited[cur[0]] = true;
            for(int[] next : list[cur[0]]) {
                if(answer[next[0]] > answer[cur[0]] + next[1]) {
                    answer[next[0]] = answer[cur[0]] + next[1];
                    q.add(new int[] {next[0], answer[next[0]]});
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            System.out.println(answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]);
        }
    }
}
