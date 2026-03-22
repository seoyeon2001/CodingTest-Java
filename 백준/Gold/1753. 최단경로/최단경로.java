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

        Deque<Integer> q = new ArrayDeque<>();

        // 시작
        visited[K] = true;
        answer[K] = 0;
        q.add(K);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int[] next : list[cur]) {
                answer[next[0]] = Math.min(answer[next[0]], answer[cur] + next[1]);
            }
//            System.out.println(cur + " answer = " + Arrays.toString(answer));

            int min = Integer.MAX_VALUE;
            int idx = -1;
            for(int i = 1; i <= V; i++) {
                if(!visited[i]) {
                    if(answer[i] < min) {
                        min = answer[i];
                        idx = i;
                    }
                }
            }
            
            if(idx != -1) {
                visited[idx] = true;
                q.add(idx);
            }
        }

        for(int i = 1; i <= V; i++) {
            System.out.println(answer[i] == Integer.MAX_VALUE ? "INF" : answer[i]);
        }
    }
}
