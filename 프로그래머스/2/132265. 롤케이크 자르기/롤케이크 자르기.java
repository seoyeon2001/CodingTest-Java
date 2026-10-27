/*
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
*/

import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
                
        Map<Integer, Integer> right = new HashMap<>();        
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }
        
        Set<Integer> left = new HashSet<>();
        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];

            left.add(t); // 왼쪽 구간에 추가
            int count = right.get(t) - 1; // 오른쪽 구간에서 제거

            if (count == 0) right.remove(t);
            else right.put(t, count);

            if (left.size() == right.size()) answer++;
        }
        return answer;
    }
}