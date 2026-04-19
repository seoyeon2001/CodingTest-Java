class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start = 1, end = 1;
        
        int sum = end;
        while(start <= end && end <= n) {
            if(sum == n) answer++;
            
            // System.out.println(start + " " + end + " " + sum);
            if(sum <= n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
            
            
        }
        return answer;
    }
}