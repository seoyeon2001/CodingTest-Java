import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        // 방법 1
        ArrayList<Character> arrayList = new ArrayList<>();
        
        for(char ch: my_string.toCharArray()) {
            if (Character.isDigit(ch)) arrayList.add(ch); 
        }
        
        Collections.sort(arrayList);
        
        int[] answer = new int[arrayList.size()];
        
        for(int i = 0; i < arrayList.size(); i++) {
            // answer[i] = Character.getNumericValue(arrayList.get(i));
            answer[i] = arrayList.get(i) - '0';
        }
    
        return answer;
        
        
        // 방법 2
        /*
        my_string = my_string.replaceAll("[a-z]",""); // 대문자는 없으니까

        int[] answer = new int[my_string.length()];

        for(int i = 0; i < my_string.length(); i++){
            answer[i] = my_string.charAt(i) - '0';
        }

        Arrays.sort(answer);

        return answer;
        */
        
        // // 방법 3 - stream
        // return Arrays.stream(my_string.replaceAll("[A-Z|a-z]", "").split("")).sorted().mapToInt(Integer::parseInt).toArray();
        
    }
}