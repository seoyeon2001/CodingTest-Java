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
        
        int[] winArr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(maps[i][j] == 1) cnt++;
            }
            winArr[i] = cnt;
        }
        
        int[] loseArr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(maps[j][i] == 1) cnt++;
            }
            loseArr[i] = cnt;
        }
        
        for(int i = 1; i <= n; i++) {
            if(winArr[i] + loseArr[i] == n-1) answer++;
        }
        return answer;
    }
}