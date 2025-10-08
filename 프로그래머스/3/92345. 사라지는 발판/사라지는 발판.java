class Solution {
    
    class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // 상하좌우
    int[] dr = {1, -1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int[][] board; // board 전역변수화
    int row, col;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        
        row = board.length;
        col = board[0].length;
        
        Point cntA = new Point(aloc[0], aloc[1]);
        Point cntB = new Point(bloc[0], bloc[1]);

        return dfs(cntA, cntB);
    }
    
    
	// me : 현재 턴인 사람 // you : 상대방
    public int dfs(Point me, Point you) {
        
        int cr = me.x;
        int cc = me.y;
        
        if(board[cr][cc] == 0) return 0;  // 발판이 사라졌다면 0 반환
        
        int result = 0; // 최종적인 턴 수
        for(int i = 0; i < 4; i++){
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            
            if(nr < 0 || nr >= row || nc < 0 || nc >= col || board[nr][nc] == 0) continue;
            
            board[cr][cc] = 0; // 이전에 서있던 곳으로 이동불가능하게 만듦
            
             // 여기서 상대방 턴이기 때문에 매개변수로 dfs(you,me) 순서로 들어간다.
            int val = dfs(you, new Point(nr, nc)) + 1; // 턴수 + 1
            
            board[cr][cc] = 1; // 사용한 것을 원상 복구
            
            // 지금까지 모두 진 경우고, 이번에 이겼을 때 -> 바로 이긴걸로 바꿔줌
            if(val % 2 == 1 && result % 2 == 0) result = val;
            
            // 지금까지도 졌고, 이 경우도 진 경우 -> 최대한 많이 움직인다.
            else if(val % 2 == 0 && result % 2 == 0 ) result = Math.max(result,val);
            
            // 지금까지도 이겼고, 이 경우도 이긴 경우 -> 최대한 적게 움직인다.
            else if(val % 2 == 1 && result % 2 == 1 ) result = Math.min(result,val);
        }
        
        return result;
    }
}