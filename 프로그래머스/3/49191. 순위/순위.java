import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        List<Integer>[] winList = new ArrayList[n+1];
        List<Integer>[] loseList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            winList[i] = new ArrayList<>();
            loseList[i] = new ArrayList<>();
        }
        
        for(int[] result : results) {
            int win = result[0], lose = result[1];
            
            winList[win].add(lose);
            loseList[lose].add(win);
        }
        
        for(int i = 1; i <= n; i++) {
            Deque<Integer> q = new ArrayDeque<>();
            boolean[] visited = new boolean[n+1];
            
            q.add(i);
            visited[i] = true;
            
            while(!q.isEmpty()) {
                int cur = q.poll();
                
                for(int next : winList[cur]) {
                    if(visited[next]) continue;
                    
                    q.add(next);
                    visited[next] = true;
                }
            }
            
            q.add(i);
            
            while(!q.isEmpty()) {
                int cur = q.poll();
                
                for(int next : loseList[cur]) {
                    if(visited[next]) continue;
                    
                    q.add(next);
                    visited[next] = true;
                }
            }
            
            boolean flag = true;
            for(int j = 1; j <= n; j++) {
                if(!visited[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}
/*
import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] maps = new int[n+1][n+1];
        
        for(int[] result : results) {
            int win = result[0], lose = result[1];
            
            maps[win][lose] = 1; 
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {                    
                    if(maps[i][k] == 1 && maps[k][j] == 1) maps[i][j] = 1;
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            int winCnt = 0;
            int loseCnt = 0;
            
            for(int j = 1; j <= n; j++) {
                if(maps[i][j] == 1) winCnt++;
                if(maps[j][i] == 1) loseCnt++;
            }
            
            if(winCnt + loseCnt == n-1) answer++;
        }
        
        return answer;
    }
}
*/