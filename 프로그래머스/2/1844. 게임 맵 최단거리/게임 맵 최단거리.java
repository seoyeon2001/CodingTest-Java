import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static int n;
    static int m;
    
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        
        answer = bfs(maps);
        
        return answer;
    }
    
    static int bfs(int[][] maps) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];

            if(r == n-1 && c == m-1) {
                return cnt;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if(maps[nr][nc] == 0) continue; // 벽
                if(visited[nr][nc]) continue;

                q.add(new int[] {nr, nc, cnt+1});
                visited[nr][nc] = true;
            }
        }
        return -1;
        
    }
}