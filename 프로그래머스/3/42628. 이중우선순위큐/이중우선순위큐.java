import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(String operation : operations) {
            String[] str = operation.split(" ");
            
            if(str[0].equals("I")) { // 삽입
                int num = Integer.valueOf(str[1]);
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if(str[0].equals("D") && str[1].equals("1") && !map.isEmpty()) { // 최댓값 삭제
                int key = map.lastKey();
                if (map.get(key) == 1) map.remove(key);
                else map.put(key, map.get(key) - 1);
            } else if(str[0].equals("D") && str[1].equals("-1") && !map.isEmpty()) { // 최솟값 삭제
                int key = map.firstKey();
                if (map.get(key) == 1) map.remove(key);
                else map.put(key, map.get(key) - 1);                
            }
        }
        
        if (map.isEmpty()) return new int[] {0, 0};
        return new int[] {map.lastKey(), map.firstKey()};
    }
}