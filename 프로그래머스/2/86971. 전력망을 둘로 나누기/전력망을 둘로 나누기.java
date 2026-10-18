import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static List<Integer>[] list;
    static int n;
    
    public int solution(int n, int[][] wires) {
        this.n = n;
        
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        
        for(int[] wire : wires) {
            list[wire[0]].remove(Integer.valueOf(wire[1]));
            list[wire[1]].remove(Integer.valueOf(wire[0]));
            
            calc();
            
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        return answer;
    }
    
    private void calc() {
        int link = 0;
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : list[cur]) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        
        for(boolean b : visited) {
            if(b) link++;
        }
        
        int other = n - link;
        
        answer = Math.min(answer, Math.abs(other - link));
    }
}