import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[][] arr = new int[topping.length-1][2];
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < topping.length-1; i++) {
            set.add(topping[i]);
            arr[i][0] = set.size();
        }
        
        set = new HashSet<>();
        for(int i = topping.length-1; i > 0; i--) {
            set.add(topping[i]);
            arr[i-1][1] = set.size();
        }
        
        for(int[] a : arr) {
            if(a[0] == a[1]) answer++;
        }
        // System.out.println(Arrays.deepToString(arr));
        return answer;
    }
}