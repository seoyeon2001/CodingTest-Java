import java.util.*;

class Solution {
    class Edge implements Comparable<Edge>{
        int node; 
        int cost;
        
        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] path : paths) {
            graph.get(path[0]).add(new Edge(path[1], path[2]));
            graph.get(path[1]).add(new Edge(path[0], path[2]));
        }
        
        Set<Integer> summitSet = new HashSet<>();
        for(int summit : summits) {
            summitSet.add(summit);
        } 
        
        Queue<Edge> q = new PriorityQueue<>();        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for(int gate : gates) {
            dist[gate] = 0;
            q.add(new Edge(gate, 0));
        }
        
        while(!q.isEmpty()) {
            Edge cur = q.poll();
            
            if(dist[cur.node] < cur.cost) continue;
            if(summitSet.contains(cur.node)) continue;
            
            for(Edge next : graph.get(cur.node)) {                
                int max = Math.max(cur.cost, next.cost);
                if(dist[next.node] > max){
                    dist[next.node] = max;
                    q.add(new Edge(next.node, dist[next.node]));
                }
            }
        }
                          
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 1; i <= n; i++) {
            if(summitSet.contains(i) && min > dist[i]) {
                min = dist[i];
                idx = i;
            }
        }
        return new int[]{idx, min};
    
    }
}