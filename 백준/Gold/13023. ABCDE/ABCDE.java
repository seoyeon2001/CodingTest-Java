import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean isSuccess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i < n; i++) {
            if(!isSuccess) {
                boolean[] visited = new boolean[n];
                visited[i] = true;

                dfs(i, visited, 1);
            }
        }
        System.out.println(isSuccess ? 1 : 0);
    }

    static void dfs(int cur, boolean[] visited, int depth) {
        if(depth == 5) {
            isSuccess = true;
            return;
        }

        for(int next: graph[cur]) {
            if(!visited[next]) {
                visited[next] = true;
                dfs(next, visited, depth+1);
                visited[next] = false;

            }
        }
    }
}
