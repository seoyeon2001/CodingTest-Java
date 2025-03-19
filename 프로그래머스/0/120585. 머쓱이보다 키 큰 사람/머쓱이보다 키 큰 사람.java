import java.util.Arrays;

class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        Arrays.sort(array); // JAVA 정렬
        for (int i=0; i<array.length; i++) {
            if (array[i] > height) {
                answer += 1;
            }
        }
        return answer;
    }
}