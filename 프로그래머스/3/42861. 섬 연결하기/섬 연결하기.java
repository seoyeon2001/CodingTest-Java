import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        // int linked = 0;
        
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] cost : costs) {
            int v = cost[0];
            int u = cost[1];
            int dist = cost[2];
            
            graph[v].add(new int[] {u, dist});
            graph[u].add(new int[] {v, dist});
        }
        
        // for(int i = 0; i < n; i++) {
        //     System.out.println(graph[i]);
        // }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        for(int[] next : graph[0]) {
            pq.add(new int[] {next[0], next[1]});
        }
        // while(!pq.isEmpty()) {
        //     int[] next = pq.poll();
        //     System.out.println(next[0] + " " + next[1]);
        // }
        
        while(!pq.isEmpty()) {
            int[] next = pq.poll();
            if(visited[next[0]]) continue;
            
            visited[next[0]] = true;
            answer += next[1];
            // linked++;            
            
            for(int[] node : graph[next[0]]) {
                pq.add(new int[] {node[0], node[1]});
            }   
        }
    
        return answer;
    }
}