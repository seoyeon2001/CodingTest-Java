import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        int maxHeight = Integer.MIN_VALUE;
        for(int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                int height = Integer.parseInt(st.nextToken());
                map[r][c] = height;
                
                if (height > maxHeight) maxHeight = height;
            }
        }
        
        int maxSafeArea = 0;
        // 비가 안올 때(1) ~ 최대의 높이일 때(0) - 1
        for (int i = 0; i < maxHeight; i++) {
            boolean[][] visited = new boolean[N][N];
            
            int safeArea = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c] && map[r][c] > i) {
                        bfs(r, c, i, visited);
                        safeArea++;
                    }
                }
            }
            
            if (safeArea > maxSafeArea) maxSafeArea = safeArea;
        }
        
        System.out.println(maxSafeArea);
    }
    
    static void bfs(int r, int c, int rain, boolean[][] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] <= rain) continue; // 물에 잠기니까 pass
                
                q.add(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}