import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new boolean[n+1];
        answer = new int[n+1];

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list[v1].add(v2);
            list[v2].add(v1);
        }

        dfs(1);

        for(int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    static void dfs(int node) {
        visited[node] = true;

        for(int next : list[node]) {
            if(!visited[next]) {
                answer[next] = node;
                dfs(next);
            }
        }
    }
}
