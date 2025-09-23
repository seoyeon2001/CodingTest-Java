import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[][] graph;
    static int[] plan;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        graph = new int[N][N];
        plan = new int[M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        dfs(plan[0] - 1);

        for (int p : plan) {
            if (!visited[p - 1]) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }

    public static void dfs(int x) {
        visited[x] = true;

        for (int i = 0; i < N; i++) {
            if (graph[x][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
