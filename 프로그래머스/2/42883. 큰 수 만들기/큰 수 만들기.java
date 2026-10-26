import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
                
        Deque<Character> deque = new ArrayDeque<>();
        deque.offerLast(number.charAt(0));
                
        for(int i = 1; i < number.length(); i++) {
            while(!deque.isEmpty() && deque.peekLast() < number.charAt(i)) {
                if(k <= 0) break;
                
                deque.pollLast();
                k--;
            }
            
            deque.offerLast(number.charAt(i));
        }
                
        while(k > 0) {
            deque.pollLast();
            k--;
        }
                
        while(!deque.isEmpty()) {
            answer += deque.pollFirst();
        }
        
        return answer;
    }
}