import java.util.*;

class Solution {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] maps;
    static Deque<int[]> q = new ArrayDeque<>();
    static int answer = -1;
    static int n;
    static int m;
    
    public int solution(int[][] maps) {        
        this.maps = maps;
        this.n = maps.length;
        this.m = maps[0].length;
        visited = new boolean[n][m];
        
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        bfs();
        
        return answer;
    }
    
    static private void bfs() {
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            
            if(r == n-1 && c == m-1) {
                answer = cnt;
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                if(!visited[nr][nc] && maps[nr][nc] != 0) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc, cnt+1});
                }
            }
        }
        
        
    }
}