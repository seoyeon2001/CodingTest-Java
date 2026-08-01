import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n+1];
        Arrays.fill(clothes, 1);
        
        for(int l : lost) {
            clothes[l]--;
        }
        for(int r : reserve) {
            clothes[r]++;
        }
        // System.out.println(Arrays.toString(clothes));
        
        for(int i = 1; i <= n; i++) {
            if(clothes[i] == 2) {
                if(clothes[i-1] == 0) {
                    clothes[i-1]++;
                    clothes[i]--;
                } else if(i < n && clothes[i+1] == 0) {
                    clothes[i+1]++;
                    clothes[i]--;
                }
                
            }
            // System.out.println(Arrays.toString(clothes));
        }
        
        for(int i = 1; i <= n; i++) {
            if(clothes[i] >= 1) answer++;
        }
        return answer;
    }
}