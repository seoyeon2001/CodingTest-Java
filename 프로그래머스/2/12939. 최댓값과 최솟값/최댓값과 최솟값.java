import java.util.*;

class Solution {
    public String solution(String s) {        
        String[] numbers = s.split(" ");
        // System.out.println(Arrays.toString(numbers));
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String number : numbers) {
            // System.out.println(number);
            
            max = Math.max(max, Integer.valueOf(number));
            min = Math.min(min, Integer.valueOf(number));
        }
        
        return min + " " + max;
    }
}