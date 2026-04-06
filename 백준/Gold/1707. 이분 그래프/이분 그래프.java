import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static boolean isCircle;
    static List<Integer>[] list;
    static int[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V+1];
            for(int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list[u].add(v); list[v].add(u);
            }

            isCircle = false;
            group = new int[V+1];
            Arrays.fill(group, -1);

            for(int i = 1; i <= V; i++) {
                if(group[i] == -1) {
                    bfs(i);
                }
            }
            sb.append(isCircle ? "NO" : "YES").append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();

        q.add(start);
        group[start] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : list[cur]) {
                if(group[next] != -1) {
                    if(group[next] == group[cur]) {
                        isCircle = true;
                        return;
                    }
                }

                if(group[next] == -1) {
                    q.add(next);
                    group[next] = (group[cur] + 1) % 2;
                }
            }
        }
    }
}
