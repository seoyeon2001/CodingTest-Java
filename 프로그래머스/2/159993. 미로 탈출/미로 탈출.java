import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int answerA = Integer.MAX_VALUE;
        int answerB = Integer.MAX_VALUE;
        
        int startR = -1, startC = -1, leverR = -1, leverC = -1, endR = -1, endC = -1;
        
        int[][] grids = new int[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            char[] tmp = maps[i].toCharArray();
            for(int j = 0; j < tmp.length; j++) {
                if(tmp[j] == 'X') grids[i][j] = 1;
                
                else if (tmp[j] == 'S') {
                    grids[i][j] = 0;
                    startR = i; startC = j;
                } else if (tmp[j] == 'E') {
                    grids[i][j] = 0;
                    endR = i; endC = j;
                } else if (tmp[j] == 'L') {
                    grids[i][j] = 0;
                    leverR = i; leverC = j;
                }
            }
        }
        // System.out.println(Arrays.deepToString(grids));
        
        Deque<int[]> q = new ArrayDeque<>();
        
        // 1. 출발에서 레버로 이동
        boolean[][] visited = new boolean[grids.length][grids[0].length];
        
        q.add(new int[] {startR, startC, 0});
        visited[startR][startC] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], cnt = cur[2];
            
            if(r == leverR && c == leverC) {
                answerA = Math.min(answerA, cnt);
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                
                if(nr < 0 || nr >= grids.length || nc < 0 || nc >= grids[0].length || 
                   grids[nr][nc] == 1 || visited[nr][nc]) continue;
                
                q.add(new int[] {nr, nc, cnt+1});
                visited[nr][nc] = true;
            }
        }
        
        // 2. 레버에서 출구로 이동
        visited = new boolean[grids.length][grids[0].length];
        
        q.add(new int[] {leverR, leverC, 0});
        visited[leverR][leverC] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], cnt = cur[2];
            
            if(r == endR && c == endC) {
                answerB = Math.min(answerB, cnt);
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i], nc = c + dc[i];
                
                if(nr < 0 || nr >= grids.length || nc < 0 || nc >= grids[0].length || 
                   grids[nr][nc] == 1 || visited[nr][nc]) continue;
                
                q.add(new int[] {nr, nc, cnt+1});
                visited[nr][nc] = true;
            }
        }
        
        
        if(answerA == Integer.MAX_VALUE || answerB == Integer.MAX_VALUE) return -1;
        
        return answerA + answerB;
    }
}