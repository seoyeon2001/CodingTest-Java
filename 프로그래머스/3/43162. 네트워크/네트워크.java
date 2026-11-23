import java.util.*;

class Solution {
    boolean[] visited;
    List<Integer>[] graph;
        
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i >= j) continue;
                if(computers[i][j] == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        // for(int i = 0; i < n; i++) {
        //     System.out.println(graph[i]);
        // }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                bfs(i);
            }
        }
        
        return answer;
    }
    
    private void bfs(int num) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(num);
        visited[num] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : graph[cur]) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}