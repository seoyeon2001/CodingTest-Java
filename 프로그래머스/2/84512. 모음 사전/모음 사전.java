import java.util.*;

class Solution {    
    static String[] wordArray = {"A", "E", "I", "O", "U"};
    static ArrayList<String> dictionary = new ArrayList<>();
    
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