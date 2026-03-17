import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;

    static boolean[] dfsVisited;
    static boolean[] bfsVisited;

    static Deque<Integer> dfsQueue = new ArrayDeque<>();
    static Deque<Integer> bfsQueue = new ArrayDeque<>();

    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }

        for(int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        dfsVisited = new boolean[n+1];
        dfs(v);
        while(!dfsQueue.isEmpty()) {
            System.out.print(dfsQueue.poll() + " ");
        }

        System.out.println();

        bfsVisited = new boolean[n+1];
        bfs(v);
        while(!bfsQueue.isEmpty()) {
            System.out.print(bfsQueue.poll() + " ");
        }
    }

    static void dfs(int num) {
        dfsQueue.add(num);
        dfsVisited[num] = true;

        for(int next : list[num]) {
            if(!dfsVisited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int num) {

        bfsVisited[num] = true;
        q.add(num);

        while(!q.isEmpty()) {
            int cur = q.poll();
            bfsQueue.add(cur);

            for(int next : list[cur]) {
                if(!bfsVisited[next]) {
                    bfsVisited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
