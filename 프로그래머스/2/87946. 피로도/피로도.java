import java.util.*;

class Solution {
    static int answer = 0;
    static int length;
    
    public int solution(int k, int[][] dungeons) {
        length = dungeons.length;
        
        permutation(0, new ArrayList<>(), new boolean[length], dungeons, k);
        return answer;
    }
    
    private void permutation(int depth, List<Integer> list, boolean[] visited, int[][] dungeons, int k) {
        if(depth == length) {
            int cnt = calc(list, dungeons, k);
            // System.out.println(cnt);
            answer = Math.max(answer, cnt);
        }
        
        for(int i = 0; i < length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(i);
                
                permutation(depth+1, list, visited, dungeons, k);
                
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
    
    private int calc(List<Integer> list, int[][] dungeons, int k) {
        int cnt = 0;
        
        for(int idx : list) {
            if(k >= dungeons[idx][0]) {
                k -= dungeons[idx][1];
                cnt++;
            }
        }
        return cnt;
    }
}






/*
// 24분
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
*/
