import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        String answer = "";
        
        long[] nums = new long[bans.length];
        
        for(int j = 0; j < bans.length; j++) {
            long num = 0;
            int wordSize = bans[j].length();
            
            for(int i = 0; i < wordSize; i++) {                
                num += (bans[j].charAt(i) - 'a' + 1) * (Math.pow(26, wordSize - i - 1));
            }            
            nums[j] = num;
        }
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        
        int cnt = 0;
        for(long num : nums) {
            if(num <= n + cnt) {
                cnt++;
            } else break;       
        }
        n += cnt;
        // System.out.println(cnt);
        
        return toWord(n);
        
//         List<Integer> word = new ArrayList<>();
//         while(n > 0) {
            
//             int ahrt = (int) n / 26;
//             int skajwl = (int) n % 26;
            
//             word.add(skajwl);
            
//             n = n / 26;            
//         }
//         // System.out.println(word);
        
//         StringBuilder sb = new StringBuilder();
//         for(int i = word.size() - 1; i >= 0; i--) {
//             sb.append((char) (word.get(i) + 96) + "");
//         }
        
//         answer = sb.toString();
        
//         return answer;
    }
    
    private String toWord(long n) {
        long len = 1, count = 26, base = 0;
        while (n > base + count) {
            base += count;
            count *= 26;
            len++;
        }
        long offset = n - base - 1;
        char[] word = new char[(int)len];
        for (int i = (int)len - 1; i >= 0; i--) {
            word[i] = (char)('a' + (offset % 26));
            offset /= 26;
        }
        return new String(word);
    }
}