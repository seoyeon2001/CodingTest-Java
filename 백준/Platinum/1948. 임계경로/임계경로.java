import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<int[]>[] list = new ArrayList[n+1];
        List<int[]>[] reverseList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new int[] {v, w});
            reverseList[v].add(new int[] {u, w, 0});
        }

        st = new StringTokenizer(br.readLine());
        int han = Integer.parseInt(st.nextToken());
        int roma = Integer.parseInt(st.nextToken());

        int[] answer = new int[n+1];
        answer[han] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.add(new int[] {han, 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            for(int[] next : list[cur[0]]) {
                 if(answer[next[0]] < cur[1] + next[1]) {
                     answer[next[0]] = cur[1] + next[1];
                     pq.add(new int[] {next[0], answer[next[0]]});
                 }
            }
        }

        System.out.println(answer[roma]);
//        System.out.println("answer = " + Arrays.toString(answer));

        Deque<Integer> q = new ArrayDeque<>();
        q.add(roma);

        int res = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int[] next : reverseList[cur]) {
                if(next[2] != 1 && answer[cur] - next[1] == answer[next[0]]) {
                    res++;
                    q.add(next[0]);
                    next[2] = 1;
                }
            }
        }

        System.out.println(res);
    }
}
