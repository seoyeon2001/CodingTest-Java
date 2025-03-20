class Solution {
    public int solution(int num1, int num2) {
        int answer = (int) ((double) num1 / num2 * 1000);
        // int answer = num1 * 1000 / num2;
        return answer;
    }
}