import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        
        // words에 target이 없으면 0 return
        if(!Arrays.asList(words).contains(target)) return 0;
        
        Deque<Pair> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];     
    
        q.add(new Pair(begin, 0));
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int cnt = p.cnt;
            
            if(word.equals(target)) {
                return cnt;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (check(word, words[i])) {
                    if(!visited[i]) {
                        q.add(new Pair(words[i], cnt+1));
                        visited[i] = true;
                    }                    
                }
            }
        }       
        return 0;
    }
    
    // 하나만 다른지 확인
    static boolean check(String word1, String word2) {
        int time = 0;
        // 다른 횟수 계산
        for(int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                time++;
            }
        }
        if (time == 1) return true;
        else return false;
    }
    
}

class Pair {
    String word;
    int cnt;

    Pair(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }

}