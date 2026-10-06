class Solution {
    public int solution(int[] nums) {
        int answer = 0;

				// 완전 탐색
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {                    
                    int sum = nums[i] + nums[j] + nums[k];
                    if (check(sum)) answer++;
                } 
            }
        }

        return answer;
    }
    
    // 소수 판별 함수 뺌
    static boolean check(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
} 