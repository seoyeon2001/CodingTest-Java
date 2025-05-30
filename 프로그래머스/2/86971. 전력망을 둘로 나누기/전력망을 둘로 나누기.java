import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 기본 세팅
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        // System.out.println(Arrays.toString(graph));
        
        // 시작
        for(int[] wire : wires) {
            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));
            
            // System.out.println(Arrays.toString(graph));
            
            int cnt1 = count(graph, n);
            int cnt2 = n - cnt1;
            int cntR = cnt1 - cnt2;
            answer = Math.min(answer, Math.abs(cntR));
            
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        
        return answer;
    }
    
    static int count(List<Integer>[] graph, int n) {
        int cnt = 0;
        
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int num = q.poll();
            
            for(int node : graph[num]) {
                if(!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                }
            }
        }
        
        for(boolean b : visited) {
            if (b) cnt++;
        }
        return cnt;
    }
}