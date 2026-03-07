import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <=n; i++) {
            list[i] = new ArrayList<>();
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        int answer = 0;
        visited = new boolean[n+1];
        q = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                answer++;
                bfs(i);
            }
        }

        System.out.println(answer);
    }

    static void bfs(int num) {
        visited[num] = true;
        q.add(num);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int nextNode : list[cur]) {
                if(!visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }
        }
    }
}
