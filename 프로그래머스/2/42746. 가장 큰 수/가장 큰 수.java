import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (a, b) -> (b+a).compareTo(a+b));
        // System.out.println(Arrays.toString(nums));
        
        for(String n : nums) {
            answer += n;
        }
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}