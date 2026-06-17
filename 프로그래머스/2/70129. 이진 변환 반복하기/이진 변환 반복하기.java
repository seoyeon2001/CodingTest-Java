// class Solution {
//     public int[] solution(String s) {
//         int[] answer = new int[2];
        
//         int removeZeroCnt = 0;
//         int time = 0;
//         while(true) {
//             if(s.length() == 1) break;
            
//             int length = s.length();
//             int nextLength = 0;
//             String[] arr = s.split("");
//             for(int i = 0; i < arr.length; i++) {
//                 int num = Integer.parseInt(arr[i]);
//                 if(num == 1) nextLength += 1;
//                 else removeZeroCnt += 1;
//             }
            
//             s = Integer.toBinaryString(nextLength);
//             time++;
//         }
        
//         answer[0] = time;
//         answer[1] = removeZeroCnt;
        
//         return answer;
//     }
// }

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
 
        while(s.length() > 1) {
            int cntOne = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') answer[1]++;
                else cntOne++;
            }
            
            s = Integer.toBinaryString(cntOne);
            answer[0]++;
        }

        return answer;
    }
}