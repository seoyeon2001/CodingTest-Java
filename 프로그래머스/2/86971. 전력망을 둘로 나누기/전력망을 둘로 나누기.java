import java.util.*;

class Solution {
    static int answer;
    static List<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        
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
            
            boolean[] visited = new boolean[n+1];
        
            // int cnt = dfs(1, visited);
            int cnt = bfs(visited);

            if(answer > Math.abs((n-cnt)-cnt)) answer = Math.abs((n-cnt)-cnt);
            
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        
        return answer;
    }
    
    static int bfs(boolean[] visited) {
        int cnt = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            
            for(int next : list[cur]) {
                if(visited[next]) continue;
                
                q.add(next);
                visited[next] = true;
            }
        }
        
        return cnt;
    }
    
    static int dfs(int num, boolean[] visited) {
        int cnt = 1;
        
        visited[num] = true;
        
        for(int link : list[num]) {
            if(!visited[link]) {                
                cnt += dfs(link, visited);
            }
        }
        
        return cnt;
    }
}