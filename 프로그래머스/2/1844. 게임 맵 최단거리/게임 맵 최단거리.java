import java.util.*;

class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
       
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[] {0, 0, 1}); // 행, 열, 칸 개수
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            
            if (r == n-1 && c == m-1) return cnt;
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] != 0 && !visited[nr][nc]) {
                    q.add(new int[] {nr, nc, cnt + 1});
                    visited[nr][nc] = true;                    
                }
            }
        }
        return -1;
    }
}