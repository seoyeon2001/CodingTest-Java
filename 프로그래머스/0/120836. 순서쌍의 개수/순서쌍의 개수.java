class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0 ) answer++;
        }
        if (Math.sqrt(n) % 1 == 0) answer = answer * 2 + 1;
        else answer = answer * 2;
            
        return answer;
    }
}