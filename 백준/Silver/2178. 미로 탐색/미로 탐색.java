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

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int cr = cur[0], cc = cur[1];

            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                if(arr[nr][nc] == 1) {
                    arr[nr][nc] = arr[cr][cc] + 1;
                    q.add(new int[] {nr, nc});
                }
            }
        }

        System.out.println(arr[n-1][m-1]);
    }
}
