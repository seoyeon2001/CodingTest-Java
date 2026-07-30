class Solution {
    static int cnt;
    
    public int solution(int[] numbers, int target) {
        
        back(numbers, target, 0, numbers[0]);
        back(numbers, target, 0, -numbers[0]);
        
        return cnt;
    }
    
    static void back(int[] numbers, int target, int idx, int num) {        
        if(idx == numbers.length-1) {
            if(num == target) {
                cnt++;
            }
            return;
        }
        
        back(numbers, target, idx+1, num + numbers[idx+1]);
        back(numbers, target, idx+1, num - numbers[idx+1]);
    }
}