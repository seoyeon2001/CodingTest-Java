/*import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] v : edge) {
            list[v[0]].add(v[1]);
            list[v[1]].add(v[0]);
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        int[] length = new int[n+1];
        Arrays.fill(length, Integer.MAX_VALUE);
        
        q.add(new int[] {1, 0});
        length[1] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int next : list[cur[0]]) {
                if(length[next] > cur[1]+1) {
                    length[next] = cur[1]+1;
                    q.add(new int[] {next, cur[1]+1});
                }
            }
        }
        
        // System.out.println(Arrays.toString(length));
        
        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(length[i] > max) {
                answer = 1;
                max = length[i];
            } else if (length[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
}
*/

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        dist[1] = 0;

        int maxDist = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                maxDist = Math.max(maxDist, dist[next]);
                queue.offer(next);
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                answer++;
            }
        }

        return answer;
    }
}
