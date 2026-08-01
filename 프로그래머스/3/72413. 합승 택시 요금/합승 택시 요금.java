import java.util.*;

class Solution {
    
    static List<int[]>[] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] fare : fares) {
            int v = fare[0];
            int u = fare[1];
            int cost = fare[2];
            
            graph[v].add(new int[] {u, cost});
            graph[u].add(new int[] {v, cost});
        }
        
        int[] fromS = minCost(s, n);
        int[] fromA = minCost(a, n);
        int[] fromB = minCost(b, n);
        
        int[][] minCosts = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            minCosts[i] = minCost(i, n);
        }
        
        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, fromS[i] + fromA[i] + fromB[i]);
        }
        
        return answer;
    }
    
    static int[] minCost(int start, int n) {
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {start, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if(cost[cur[0]] < cur[1]) continue;
            
            for(int[] next : graph[cur[0]]) {
                int nextNode = next[0];
                int nextCost = next[1];
                
                if(cost[nextNode] > cur[1] + nextCost) {
                    cost[nextNode] = cur[1] + nextCost;
                    pq.add(new int[] {nextNode, cost[nextNode]});
                }
            }
        }
        
        return cost;
    }
}