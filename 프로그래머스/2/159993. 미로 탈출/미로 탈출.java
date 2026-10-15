import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] maps) {        
        int startR = -1, startC = -1, leverR = -1, leverC = -1, endR = -1, endC = -1;
        
        int[][] grids = new int[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[i].length(); j++) {
                if(maps[i].charAt(j) == 'X') grids[i][j] = 1;
                
                else if (maps[i].charAt(j) == 'S') {
                    grids[i][j] = 0;
                    startR = i; startC = j;
                } else if (maps[i].charAt(j) == 'E') {
                    grids[i][j] = 0;
                    endR = i; endC = j;
                } else if (maps[i].charAt(j) == 'L') {
                    grids[i][j] = 0;
                    leverR = i; leverC = j;
                }
            }
        }
        // System.out.println(Arrays.deepToString(grids));
                
        // 1. 출발에서 레버로 이동
        int answerA = bfs(grids, startR, startC, leverR, leverC);
        
        // 2. 레버에서 출구로 이동
        int answerB = bfs(grids, leverR, leverC, endR, endC);
        
        if(answerA == -1 || answerB == -1) return -1;
        
        return answerA + answerB;
    }
    
    private int bfs(int[][] grids, int fromR, int fromC, int toR, int toC) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[grids.length][grids[0].length];
        
        q.add(new int[] {fromR, fromC, 0});
        visited[fromR][fromC] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], cnt = cur[2];
            
            if(r == toR && c == toC) return cnt;
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                
                if(nr < 0 || nr >= grids.length || nc < 0 || nc >= grids[0].length || 
                   grids[nr][nc] == 1 || visited[nr][nc]) continue;
                
                q.add(new int[] {nr, nc, cnt+1});
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
}