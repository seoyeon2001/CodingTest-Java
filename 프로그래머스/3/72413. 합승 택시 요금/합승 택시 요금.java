import java.util.*;

class Solution {
    static List<List<Edge>> graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare : fares) {
            graph.get(fare[0]).add(new Edge(fare[1], fare[2]));
            graph.get(fare[1]).add(new Edge(fare[0], fare[2]));
        }
        
        int[][] minDists = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) { // 각 노드별 최소 비용
            minDists[i] = minDist(i, n);
        }
        
        /*
        for (int i = 1; i <= n; i++) {
            System.out.println(Arrays.toString(minDists[i]));
        }
        */
        
        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            result = Math.min(result, (minDists[s][i] + minDists[i][a] + minDists[i][b]));
        }
        
        
        return result;
    }
    
    static int[] minDist(int startNode, int n) {
        Queue<Edge> q = new PriorityQueue<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        q.add(new Edge(startNode, 0));
        dist[startNode] = 0;
        
        while(!q.isEmpty()) {
            Edge cur = q.poll();
            
            if (cur.cost > dist[cur.node]) continue;
            
            for(Edge next : graph.get(cur.node)) {
                int nextDist = dist[cur.node] + next.cost;
                if(dist[next.node] > nextDist) {
                    q.add(new Edge(next.node, nextDist));
                    dist[next.node] = nextDist;
                }
            }
        }
        
        // System.out.println(Arrays.toString(dist));
        return dist;
    }
}

class Edge implements Comparable<Edge> {
    int node;
    int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}