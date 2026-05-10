import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int max = citations[citations.length-1];
        int[] arr = new int[max+1];
        
        for(int citation : citations) {
            arr[citation]++;
        }
        
        for(int i = max-1; i >= 0; i--) {
            arr[i] += arr[i+1];
        }
        
        System.out.println(Arrays.toString(arr));
        
        for(int i = max; i >= 0; i--) {
            if(i <= arr[i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
//         int left = 0;
//         int right = max;
        
//         while(left <= right) {
//             int mid = (left + right) / 2;
            
//             if(mid < arr[mid]) {
//                 left = mid + 1;
//             } else if(mid > arr[mid]) {
//                 right = mid - 1;
//             } else {
//                 answer = mid;
//                 break;
//             }
//         }
        
        
        return answer;
    }
}