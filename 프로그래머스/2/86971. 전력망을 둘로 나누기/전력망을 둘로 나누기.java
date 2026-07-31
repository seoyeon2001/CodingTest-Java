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
            
            calc(list, n);
            
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        
        return answer;
    }
    
    static void calc(List<Integer>[] list, int n) {        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        
        int cnt = dfs(1, visited, list);
        
        if(answer > Math.abs((n-cnt)-cnt)) answer = Math.abs((n-cnt)-cnt);
    }
    
    static int dfs(int num, boolean[] visited, List<Integer>[] list) {
        int cnt = 1;
        
        visited[num] = true;
        
        for(int link : list[num]) {
            if(!visited[link]) {
                visited[link] = true;
                
                cnt += dfs(link, visited, list);
            }
        }
        
        return cnt;
    }
}