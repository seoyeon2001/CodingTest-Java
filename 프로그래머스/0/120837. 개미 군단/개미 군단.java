class Solution {
    public int solution(int hp) {
        int answer = 0;
        int major = hp / 5;
        hp -= major * 5;
        int soldier = hp / 3;
        hp -= soldier * 3;
        answer = major + soldier + hp;
        return answer;
    }
}