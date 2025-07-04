import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        // 첫번째 포함 안해 = 마지막 포함
        int[] newMoney = new int[n];
        newMoney[0] = money[n-1];
        for (int i = 1; i < n; i++) {
            newMoney[i] = money[n-1-i];
        }
        dp1[0] = newMoney[0];
        dp1[1] = newMoney[0];
        for(int i = 2; i < n-1; i++) {
            dp1[i] = Math.max(dp1[i-1], (dp1[i-2] + newMoney[i]));
        }
        
        // 첫번째 포함해 = 마지막 포함 안해
        dp2[0] = money[0];
        dp2[1] = money[0];
        for(int i = 2; i < n-1; i++) {
            dp2[i] = Math.max(dp2[i-1], (dp2[i-2] + money[i]));
        }
        
        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));
        
        // Arrays.sort(dp1);
        // Arrays.sort(dp2);
        return Math.max(dp1[n-2], dp2[n-2]);
    }
}