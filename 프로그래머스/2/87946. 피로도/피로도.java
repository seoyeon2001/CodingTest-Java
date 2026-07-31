import java.util.*;

class Solution {
    static int answer = 0;
    static int n;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        
        permutation(k, dungeons, new ArrayList<>(), new boolean[n]);
        
        return answer;
    }
    
    static void permutation(int k, int[][] dungeons, List<Integer> list, boolean[] visited) {
        if(list.size() == n) {
            // System.out.println(list);
            
            calc(k, dungeons, list);
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            list.add(i);
            
            permutation(k, dungeons, list, visited);
            
            int num = list.remove(list.size()-1);
            visited[num] = false;
        }
    }
    
    static void calc(int k, int[][] dungeons, List<Integer> idxs) {
        int cnt = 0;
        
        for(int idx : idxs) {
            if(k >= dungeons[idx][0]) {
                k -= dungeons[idx][1];
                cnt++;
            } else break;
        }
        
        if(answer < cnt) answer = cnt;
    }
}