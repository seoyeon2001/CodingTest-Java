class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        // // 방법 1
        // for ( int i = 0; i < s1.length; i++ ) {
        //     for ( int j = 0; j < s2.length; j++ ) {
        //         if (s1[i].equals(s2[j])) answer++;
        //     }
        // }
        
        // 방법 2
        for(String str1: s1){
            for(String str2: s2) {
                if (str1.equals(str2)) answer++;
            }
        }
        
        return answer;
    }
}