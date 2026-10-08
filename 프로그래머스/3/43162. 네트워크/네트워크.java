import java.util.*;

/*
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
*/

class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    private void bfs(int num, int n, int[][] computers) {
        Deque<Integer> q = new ArrayDeque<>();
        
        q.add(num);
        visited[num] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < n; i++) {
                if(cur != i && computers[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        
    }
}