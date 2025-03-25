import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
//         ArrayList<Character> arrayList = new ArrayList<>();
        
//         for(char ch: my_string.toCharArray()) {
//             if (Character.isDigit(ch)) arrayList.add(ch); 
//         }
        
//         Collections.sort(arrayList);
        
//         int[] answer = new int[arrayList.size()];
        
//         for(int i = 0; i < arrayList.size(); i++) {
//             answer[i] = Character.getNumericValue(arrayList.get(i));
//         }
    
//         return answer;
        return Arrays.stream(my_string.replaceAll("[A-Z|a-z]", "").split(""))
            .sorted().mapToInt(Integer::parseInt)
            .toArray();
    }
}