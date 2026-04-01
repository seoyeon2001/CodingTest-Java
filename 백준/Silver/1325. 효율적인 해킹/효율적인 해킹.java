import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] list;
    static int[] answer;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }

        answer = new int[n+1];

        for(int i = 1; i <= n; i++) {
            if(list[i].isEmpty()) continue;

            res = 1;
            bfs(i);
            answer[i] = res;
        }
//        System.out.println("answer = " + Arrays.toString(answer));

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            max = Math.max(max, answer[i]);
        }

        for(int i = 1; i <= n; i++) {
            if(answer[i] == max) System.out.print(i + " ");
        }

    }

    static void bfs(int i) {
        boolean[] visited = new boolean[n+1];
        Deque<Integer> q = new ArrayDeque<>();

        visited[i] = true;
        q.add(i);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : list[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    res++;
                }
            }
        }
    }
}
