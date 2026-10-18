/*
import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        
        int[] arr = {781, 156, 31, 6, 1};
        
        char[] c = word.toCharArray();
        for(int i = 0; i < word.length(); i++) {
            answer += map.get(c[i]) * arr[i];
            answer++;
        }
                              
        return answer;
    }
}
*/
import java.util.*;

class Solution {    
    static String[] wordArray = {"A", "E", "I", "O", "U"};
    static List<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        
        for(int i = 1; i <= 5; i++) {
            duplePermutation(i, new ArrayList<>());
        }
        
        Collections.sort(dictionary);
        return dictionary.indexOf(word) + 1;
    }
    
    public void duplePermutation(int r, List<Integer> list) {
        if(list.size() == r) {
            String w = "";
            for(int idx : list) {
                w += wordArray[idx];
            }
            dictionary.add(w);
            // System.out.println(list);
            return;
        }
        
        for(int i = 0; i < 5; i++) {
            list.add(i);
            
            duplePermutation(r, list);
            
            list.remove(list.size()-1);
        }
    }
}