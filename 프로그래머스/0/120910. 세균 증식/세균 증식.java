class Solution {
    public int solution(int n, int t) {
        // int answer = n * (int) Math.pow(2, t);
        int answer = n << t;
        return answer;
    }
}