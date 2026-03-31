import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        int[] answer = new int[n+1];
        Arrays.fill(answer, Integer.MAX_VALUE);

        Deque<int[]> q = new ArrayDeque<>();

        answer[x] = 0;
        q.add(new int[] {x, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int next : list[cur[0]]) {
                if(answer[next] < cur[1]+1) continue;

                q.add(new int[] {next, cur[1]+1});
                answer[next] = cur[1] + 1;
            }
        }

        for(int i = 1; i <= n; i++) {
            if(answer[i] == k) sb.append(i).append("\n");
        }
        
        if(sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);

    }
}
