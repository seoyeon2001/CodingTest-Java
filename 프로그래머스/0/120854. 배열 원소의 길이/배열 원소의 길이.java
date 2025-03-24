// class Solution {
//     public int[] solution(String[] strlist) {
//         int[] answer = new int[strlist.length];
//         for ( int i = 0; i < strlist.length; i++) {
//             answer[i] = strlist[i].length();
//         }
//         return answer;
//     }
// }

import java.util.ArrayList;

class Solution {
    public ArrayList solution(String[] strlist) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for(String str : strlist){
            answer.add(str.length());
        }
        return answer;
    }
}