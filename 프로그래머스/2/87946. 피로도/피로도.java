import java.util.*;

class Solution {
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        permutation(k, dungeons, dungeons.length, new boolean[dungeons.length], new ArrayList<>());
        
        return answer;
    }
    
    static void permutation(int k, int[][] dungeons, int n, boolean[] visited, List<Integer> list) {
        if(list.size() == n) {
            // System.out.println(list);
            int res = calc(k, dungeons, list);
            
            if(res > answer) {
                answer = res;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);
                
                permutation(k, dungeons, n, visited, list);
                
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    
    static int calc(int k, int[][] dungeons, List<Integer> list) {
        
        int answer = 0;
        
        for(int idx : list) {
            int min = dungeons[idx][0];
            int minus = dungeons[idx][1];
            
            if(k >= min) {
                k -= minus;
                answer++;
            }
        }
        
        // System.out.println(answer);
        
        return answer;        
    }
}