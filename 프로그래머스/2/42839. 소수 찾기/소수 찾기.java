import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static char[] nums;
    
    public int solution(String numbers) {
        int answer = 0;
        
        nums = numbers.toCharArray();
        // System.out.println(Arrays.toString(nums));
        
        for(int cnt = 1; cnt <= numbers.length(); cnt++) {
            permutation(cnt, new ArrayList<>(), numbers.length()-1, new boolean[nums.length]);
        }
        
        // System.out.println(set);
        
        for(int number : set) {
            if(isPrime(number)) answer++;
        }
        return answer;
    }
    
    static void permutation(int cnt, List<Integer> list, int maxIdx, boolean[] visited) {        
        if(list.size() == cnt) {
            // System.out.println(list);
            calc(list);
            return;
        }
        
        for(int i = 0; i <= maxIdx; i++) {            
            if(visited[i]) continue;
            
            list.add(i);
            visited[i] = true;
            
            permutation(cnt, list, maxIdx, visited);
            
            int num = list.remove(list.size()-1);
            visited[num] = false;
        }
        
        
    }
    
    static void calc(List<Integer> list) {
        String s = "";
        
        for(int i : list) {
            s += nums[i];
        }
        
        int number = Integer.valueOf(s);
        if(number != 0) set.add(number);
    }
    
    static boolean isPrime(int num) {
        if(num == 1) return false;
        
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
}