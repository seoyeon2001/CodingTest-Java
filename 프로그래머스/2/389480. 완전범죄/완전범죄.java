import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {        
        // dp[b] = B 흔적이 b일 때 가능한 A 흔적의 최솟값
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 아무 물건도 훔치지 않은 상태
        // B 흔적 0, A 흔적 0
        dp[0] = 0;
        
        for (int[] item : info) {
            int a = item[0]; int b = item[1];

            int[] next = new int[m];
            Arrays.fill(next, Integer.MAX_VALUE);

            for (int bTrace = 0; bTrace < m; bTrace++) {
                if (dp[bTrace] == Integer.MAX_VALUE) continue;

                int aTrace = dp[bTrace];

                // 1. A가 이번 물건을 훔치는 경우
                if (aTrace + a < n) {
                    next[bTrace] = Math.min(next[bTrace], aTrace + a);
                }

                // 2. B가 이번 물건을 훔치는 경우
                if (bTrace + b < m) {
                    next[bTrace + b] = Math.min(next[bTrace + b], aTrace);
                }
            }

            dp = next;
        }
        
        int answer = Integer.MAX_VALUE;

        for (int aTrace : dp) {
            answer = Math.min(answer, aTrace);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}