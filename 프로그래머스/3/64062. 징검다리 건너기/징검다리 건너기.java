// import java.util.*;

// class Solution {
//     public int solution(int[] stones, int k) {
//         int left = 0;
//         int right = 200000000;

//         int answer = 0;
//         while(left <= right) {
//             int mid = (left + right) / 2;

//             if(canGo(stones, k, mid)){ // 건널 수 있으면 더 많은 인원이 건널 수 있음
//                 answer = mid; // 일단 가능한 상황 저장
//                 left = mid + 1;
//             } else{ // 건널 수 없으면 더 적은 인원만 건널 수 있음
//                 right = mid - 1;
//             }
//         }
//         return answer + 1;
//     }

//     public static boolean canGo(int[] stones, int k, int mid){
//         int jumpTime = 0;

//         /**
//          * mid명을 보냈을 때, 각 디딤돌의 값은 stone - mid
//          * 이 값이 0 이하가 되는 디딤돌이 k개 이상 연속되면 더 이상 건널 수 없음
//          */
//         for (int stone : stones) {
//             if(stone - mid <= 0){
//                 jumpTime++;
//                 if (jumpTime == k) return false;
//             } else{
//                 jumpTime = 0;
//             }
//         }
//         return true;
//     }
// }


// import java.util.*;

// public class Solution {

//     public static int solution(int[] stones, int k) {
//         int n = stones.length;

//         // 연결 리스트처럼 사용할 prev, next 배열
//         int[] prev = new int[n];
//         int[] next = new int[n];

//         for (int i = 0; i < n; i++) {
//             prev[i] = i - 1;
//             next[i] = i + 1;
//         }

//         // 인덱스를 stones 값 기준으로 정렬
//         Integer[] indices = new Integer[n];
//         for (int i = 0; i < n; i++) indices[i] = i;

//         Arrays.sort(indices, Comparator.comparingInt(i -> stones[i]));

//         int answer = 0;

//         for (int idx : indices) {
//             answer = stones[idx];

//             // 연결 끊기 (경계 검사 추가)
//             if (prev[idx] >= 0) next[prev[idx]] = next[idx];
//             if (next[idx] < n) prev[next[idx]] = prev[idx];

//             // 삭제 후 간격 확인
//             int left = prev[idx];
//             int right = next[idx];
//             if (right - left > k) break;
//         }

//         return answer;
//     }

// }


// import java.util.*;

// public class Solution {

//     public static int solution(int[] nums, int k) {
//         Deque<Integer> deque = new ArrayDeque<>(); // 인덱스 저장
//         List<Integer> maxList = new ArrayList<>();
//         List<Integer> minList = new ArrayList<>();

//         for (int i = 0; i < nums.length; i++) {
//             // 윈도우 벗어난 인덱스 제거
//             while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
//                 deque.pollFirst();
//             }

//             // 새로 들어오는 값보다 작거나 같은 값들 제거 (최댓값을 유지)
//             while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
//                 deque.pollLast();
//             }

//             deque.offerLast(i); // 현재 인덱스 추가

//             // 윈도우가 k 사이즈가 된 순간부터 최댓값 기록
//             if (i >= k - 1) {
//                 int maxVal = nums[deque.peekFirst()];
//                 maxList.add(maxVal);

//                 // 최소값 계산은 별도로 O(k) 반복 (혹은 다른 Deque 만들 수도 있음)
//                 int minVal = nums[i - k + 1];
//                 int minIdx = i - k + 1;
//                 for (int j = i - k + 1; j <= i; j++) {
//                     if (nums[j] < minVal) {
//                         minVal = nums[j];
//                         minIdx = j;
//                     }
//                 }
//                 minList.add(minVal);

//                 System.out.println("Window [" + (i - k + 1) + " ~ " + i + "]: max = " + maxVal + ", min = " + minVal);
//             }
//         }
//         return 1;
//     }
// }



import java.util.*;

public class Solution {
    public static int solution(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int minOfMax = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // 윈도우 범위 밖 인덱스 제거
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 현재 값보다 작거나 같은 값들은 제거 (최댓값 유지용)
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // 윈도우가 k 크기일 때부터 처리
            if (i >= k - 1) {
                int currentMax = nums[deque.peekFirst()];
                minOfMax = Math.min(minOfMax, currentMax);

                // System.out.println("Window [" + (i - k + 1) + " ~ " + i + "]: max = " + currentMax);
            }
        }

        return minOfMax;
    }

}
