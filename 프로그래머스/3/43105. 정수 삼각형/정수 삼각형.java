import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int depth = triangle.length;
        
        int[][] dp = new int[depth][depth];
        
        for(int i = 0; i < depth; i++) {
            dp[depth-1][i] = triangle[depth-1][i];
        }
        
        // System.out.println(Arrays.deepToString(dp));
        
        for(int i = depth-1; i >= 0; i--) {
            for(int j = 0; j < i; j++) {
                int max = Math.max(triangle[i][j], triangle[i][j+1]);
                
                triangle[i-1][j] = triangle[i-1][j] + max;
            }
            // System.out.println(Arrays.deepToString(dp));
        }
        return triangle[0][0];
    }
}