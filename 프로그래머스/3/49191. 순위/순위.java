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