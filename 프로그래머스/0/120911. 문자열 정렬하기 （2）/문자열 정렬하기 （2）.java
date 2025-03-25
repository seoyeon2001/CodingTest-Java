import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] c_array = my_string.toCharArray();
        
        for(int i = 0; i < c_array.length; i++) {
            // if (Character.isUpperCase(c_array[i])) {
            //     c_array[i] = Character.toLowerCase(c_array[i]);
            // }
            c_array[i] = Character.toLowerCase(c_array[i]);
        }
        
        Arrays.sort(c_array);
        answer = String.valueOf(c_array);
        return answer;
        
        
        // char[] c = my_string.toLowerCase().toCharArray();
        // Arrays.sort(c);
        // return new String(c);
    }
}