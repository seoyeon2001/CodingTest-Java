import java.util.*;


class Solution {
    static List<Integer> sumList;
    
    public int solution(int[] nums) {
        int answer = 0;
        
        sumList = new ArrayList<>();   
        
        combi(new ArrayList<>(), nums, 0);
        
        // System.out.println(set);
        
        for(int s : sumList) {
            if(isPrime(s)) answer++;
        }


        return answer;
    }
    
    private void combi(List<Integer> list, int[] nums, int start) {
        if(list.size() == 3) {
            int sum = 0;
            for(int index : list) {
                sum += nums[index];
            }
            sumList.add(sum);
            return;
        }
        
        for(int i = start; i < nums.length; i++) {
            list.add(i);
                
            combi(list, nums, i+1);

            list.remove(list.size()-1); 
        }
    }
    
    private boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
