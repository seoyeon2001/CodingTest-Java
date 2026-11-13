import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pqAsc = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> pqDesc = new PriorityQueue<>((a, b) -> b - a);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String operation : operations) {
            String[] str = operation.split(" ");
            
            if(str[0].equals("I")) { // 삽입
                int num = Integer.valueOf(str[1]);
                pqAsc.offer(num);
                pqDesc.offer(num);
                map.put(num, num);
            } else if(str[0].equals("D") && str[1].equals("1")) { // 최댓값 삭제
                pqAsc.remove(pqDesc.poll());
            } else if(str[0].equals("D") && str[1].equals("-1")) { // 최솟값 삭제
                pqDesc.remove(pqAsc.poll());
            }
        }
                                            
        if(pqAsc.isEmpty()) return new int[] {0, 0};
        return new int[] {pqDesc.peek(), pqAsc.peek()};
    }
}