import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        
        // int[] arr = new int[n*n];
        // for(int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         arr[n*i+j] = Math.max(i, j) + 1;
        //     }
        // }
        
        // System.out.println(Arrays.toString(arr));
        
        // for(int i = (int) left; i <= (int) right; i++) {
        //     answer[(int) (i-left)] = arr[i];
        // }
        
        long[] start = {left / n, left % n};
        long[] end = {right / n, right % n};
        
        // System.out.println(Arrays.toString(start));
        // System.out.println(Arrays.toString(end));
        
        int tmp = 0;
        for(long idx = left; idx <= right; idx++) {
            int num = (int) Math.max(idx / n, idx % n) + 1;
            answer[tmp++] = num;
        }
        
        return answer;
    }
}