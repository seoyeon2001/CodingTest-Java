import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        
        return dfs(info, edges, visited, 1, 0);
    }
    
    int dfs(int[] info, int[][] edges, boolean[] visited, int sheep, int wolf) {

        if (sheep <= wolf) return sheep;
        int maxSheep = sheep;
        
        for (int[] edge : edges) {
            final int parent = edge[0];
            final int child = edge[1];
            // 부모가 방문된 상태이고 자식이 아직 방문되지 않은 상태라면 방문한다.
            if (visited[parent] && !visited[child]) {
                visited[child] = true;
                
                if (info[child] == 0) {
                    maxSheep = Math.max(maxSheep, dfs(info, edges, visited, sheep + 1, wolf));
                } else {
                    maxSheep = Math.max(maxSheep, dfs(info, edges, visited, sheep, wolf + 1));
                }
                // 다음 노드를 방문표시 해제한다.
                visited[child] = false;
            }
        }
        
        return maxSheep;
    }
}