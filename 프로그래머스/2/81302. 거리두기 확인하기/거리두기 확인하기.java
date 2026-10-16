import java.util.*;

class Solution {    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            answer[i] = check(places[i]);
        }
        return answer;
    }

    private int check(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!checkDistance(place, r, c)) return 0;
                }
            }
        }
        return 1;
    }
    
    private boolean checkDistance(String[] place, int r, int c) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c, 0});

        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0], cc = cur[1], dist = cur[2];

            if (dist >= 1 && place[cr].charAt(cc) == 'P') return false;
            if (dist == 2) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d], nc = cc + dc[d];
                
                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc]) continue;

                if (place[nr].charAt(nc) != 'X') {
                    q.add(new int[]{nr, nc, dist + 1});
                    visited[nr][nc] = true;
                }
            }
        }

        return true;
    }
}