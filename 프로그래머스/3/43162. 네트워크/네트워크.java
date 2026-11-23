import java.util.*;

class Solution {
    boolean[] visited;
        
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                bfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    private void bfs(int num, int n, int[][] computers) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(num);
        visited[num] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < n; i++) {
                if(cur != i && computers[cur][i] == 1 && !visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}