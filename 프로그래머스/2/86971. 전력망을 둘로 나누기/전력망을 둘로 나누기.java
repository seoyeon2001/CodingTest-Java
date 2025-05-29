import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 기본 세팅
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        // System.out.println(Arrays.toString(graph));

        // 전선 끊기 -> n-1번 반복
        for (int[] wire : wires) {
            graph[wire[0]].remove(Integer.valueOf(wire[1]));
            graph[wire[1]].remove(Integer.valueOf(wire[0]));
            // System.out.println(Arrays.toString(graph));

            int cnt1 = check(graph, n);
            int cnt2 = n - cnt1;

            answer = Math.min(answer, Math.abs(cnt1-cnt2));

            // 다시 붙이기
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }

        return answer;
    }

    static int check(List<Integer>[] graph, int n) {
        int cnt = 0;

        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int v = q.poll();

            for (int node : graph[v]) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                }
            }
        }
        for (boolean b : visited) {
            if (b) cnt++;
        }
        // System.out.println(cnt);
        return cnt;
    }
}