import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] list;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    private void dfs(int num) {
        visited[num] = true;
        
        for(int next : list[num]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
        
    }
}