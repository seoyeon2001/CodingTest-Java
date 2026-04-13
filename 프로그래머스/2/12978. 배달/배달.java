import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[][] map = new int[N+1][N+1];
        for(int i = 0; i <= N; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        
        for(int[] r : road) {
            map[r[0]][r[1]] = Math.min(map[r[0]][r[1]], r[2]);
            map[r[1]][r[0]] = Math.min(map[r[0]][r[1]], r[2]);
        }
        
        for(int i = 0; i <= N; i++) {
            map[i][i] = 0;
        }
        
        // System.out.println(Arrays.deepToString(map));
        
//         for(int i = 1; i <= N; i++) {
//             for(int j = 1; j <= N; j++) {
//                 if(i == j) continue;
                
//                 for(int k = 1; k <= N; k++) {
//                     // System.out.println(i + " " + j + " " + k);
//                     if(map[i][k] + map[k][j] >= 0 && map[i][k] + map[k][j] < map[i][j]) {
//                         map[i][j] = map[i][k] + map[k][j];
//                     }
                    
//                 }
//                 // System.out.println(Arrays.deepToString(map));
//             }
        
        for(int k = 1; k <= N; k++) {
             for(int j = 2; j <= N; j++) {
                // System.out.println(i + " " + j + " " + k);
                if(map[1][k] + map[k][j] >= 0 && map[1][k] + map[k][j] < map[1][j]) {
                    map[1][j] = map[1][k] + map[k][j];
                }

            }
        }
        
        // System.out.println(Arrays.deepToString(map));
        
        for(int i = 1; i <= N; i++) {
            if(map[1][i] <= K) answer++;
        }

        return answer;
    }
}