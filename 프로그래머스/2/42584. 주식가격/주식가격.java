// import java.util.*;

// class Solution {
//     public int[] solution(int[] prices) {
//         int[] answer = new int[prices.length];
        
//         for(int i = 0; i < prices.length; i++) {
//             int cnt = 0;
            
//             for(int j = i+1; j < prices.length; j++) {
//                 cnt++;
//                 if(prices[i] > prices[j]) break;
//             }
//             answer[i] = cnt;
//         }
    
//         return answer;
//     }
// }


import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            // 스택에 있는 인덱스 중 가격이 더 높았던 시점들은 이 시점(i)에서 가격 하락
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            // 현재 인덱스를 스택에 저장
            stack.push(i);
        }

        // 끝까지 가격이 떨어지지 않은 경우 처리
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }        
    
        return answer;
    }
}