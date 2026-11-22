import java.util.*;

class Solution {
    class Node {
        String word;
        int cnt;
        
        Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Deque<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        q.offer(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            String curWord = cur.word;
            int curCnt = cur.cnt;
            
            // cur == target인지 확인
            if(curWord.equals(target)) {
                return curCnt;
            }

            for (int i = 0; i < words.length; i++) {
                if(visited[i]) continue;
                
                int cha = 0;                    
                for(int j = 0; j < curWord.length(); j++) {
                    if(curWord.charAt(j) != words[i].charAt(j)) cha++;
                    
                    if(cha > 1) break;
                }
                
                if(cha == 1) {
                    q.offer(new Node(words[i], curCnt+1));
                    visited[i] = true;
                }   
            }
        }
        return answer;
    }
}