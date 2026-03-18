import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

//        System.out.println(Arrays.deepToString(arr));

        int answer = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();

        visited[0][0] = true;
        q.add(new int[] {0, 0, 1});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int cr = cur[0], cc = cur[1], cnt = cur[2];

            if(cr == n-1 && cc == m-1) {
                answer = Math.min(answer, cnt);
            }

            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                if(arr[nr][nc] == 0 || visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new int[] {nr, nc, cnt+1});
            }
        }

        System.out.println(answer);
    }
}
