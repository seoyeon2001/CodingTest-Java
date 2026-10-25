import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        
        String[] nums = new String[size];
        for(int i = 0; i < size; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (a, b) -> (b+a).compareTo(a+b));
        
        for(String n : nums) {
            answer += n;
        }
        
        if(answer.charAt(0) == '0') return "0";
        
        return answer;
    }
}