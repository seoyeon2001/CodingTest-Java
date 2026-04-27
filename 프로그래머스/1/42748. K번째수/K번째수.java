import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int start = command[0];
            int end = command[1];
            int target = command[2];
            
            // int[] arr = new int[end - start + 1];
            // for(int j = start-1; j < end; j++) {
            //     arr[j-start+1] = array[j];
            // }
            
            int[] arr = Arrays.copyOfRange(array, start-1, end);
            System.out.println(Arrays.toString(arr));
            
            Arrays.sort(arr);
            answer[i] = arr[target-1];
        }
        return answer;
    }
}