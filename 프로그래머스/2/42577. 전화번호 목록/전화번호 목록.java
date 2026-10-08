import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        // System.out.println(Arrays.toString(phone_book));
        
        String first = phone_book[0];
        
        for(int i = 1; i < phone_book.length; i++) {
            String com = phone_book[i];
            
            if(com.startsWith(first)) return false;
            
            first = com;
            
        }
        return answer;
    }
}