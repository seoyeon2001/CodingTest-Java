import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for(String calling : callings) {
            int idx = map.get(calling);
            
            String front = players[idx-1];
            players[idx] = front;
            players[idx-1] = calling;
            
            map.put(calling, idx-1);
            map.put(front, idx);            
        }

        answer = players;
        
        
        return answer;
    }
}