import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] answer;
    static List<int[]>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            while(true) {
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break;
                int dist = Integer.parseInt(st.nextToken());

                list[v].add(new int[] {num, dist});
            }
        }

        answer = new int[n+1];
        bfs(1);

        int max = 1;
        for(int i = 2; i <= n; i++) {
            if(answer[max] < answer[i]) {
                max = i;
            }
        }

        answer = new int[n+1];
        bfs(max);

        Arrays.sort(answer);
        System.out.println(answer[n]);
    }

    static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        visited = new boolean[n+1];

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int[] next :list[cur]) {
                if(!visited[next[0]]) {
                    visited[next[0]] = true;
                    q.add(next[0]);
                    answer[next[0]] = answer[cur] + next[1];
                }
            }
        }
    }
}
