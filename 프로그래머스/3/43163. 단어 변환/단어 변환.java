import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        Deque<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair(begin, 0));
        
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            String curWord = cur.word;
            int curCnt = cur.cnt;
            
            if (curWord.equals(target)) return curCnt;
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && check(curWord, words[i])) {
                    q.add(new Pair(words[i], curCnt + 1));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    // 한 개의 알파벳만 다른지 확인하는 메서드
    static boolean check(String word1, String word2) {
        int cnt = 0;
        
        int length = word1.length();
        for (int i = 0; i < length; i++) {
            // 다르면 cnt++
            if (word1.charAt(i) != word2.charAt(i)) cnt++;
        }
        
        if (cnt != 1) return false;
        
        return true;
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