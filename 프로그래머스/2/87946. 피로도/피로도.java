import java.util.*;

// class Solution {
//     static int answer;
    
//     public int solution(int k, int[][] dungeons) {
//         answer = -1;
//         int n = dungeons.length;
        
//         permutation(n, new ArrayList<>(), new boolean[n], k, dungeons);
//         return answer;
//     }
    
//     private void permutation(int n, List<Integer> list, boolean[] visited, int k, int[][] dungeons) {
//         if(list.size() == n) {
//             // System.out.println(list);
//             calc(list, k, dungeons);
//             return;
//         }
        
//         for(int i = 0; i < n; i++) {
//             if(!visited[i]) {
//                 list.add(i);
//                 visited[i] = true;
                
//                 permutation(n, list, visited, k, dungeons);

//                 list.remove(list.size()-1);
//                 visited[i] = false;
//             }
//         }
//     }
    
//     private void calc(List<Integer> list, int k, int[][] dungeons) {
//         int cnt = 0;
        
//         for(int idx : list) {
//             if(k >= dungeons[idx][0]) {
//                 k -= dungeons[idx][1];
//                 cnt++;
//             } else {
//                 break;
//             }
//         }
//         // System.out.println(cnt);
//         if(cnt > answer) answer = cnt;
//     }
// }


class Solution {
    int answer = 0;

    public int solution(int k, int[][] dungeons) {

        dfs(k, 0, new boolean[dungeons.length], dungeons);

        return answer;
    }

    private void dfs(int k, int count, boolean[] visited, int[][] dungeons) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;

                dfs(k-dungeons[i][1], count+1, visited, dungeons);

                visited[i] = false;
            }
        }
    }
}
