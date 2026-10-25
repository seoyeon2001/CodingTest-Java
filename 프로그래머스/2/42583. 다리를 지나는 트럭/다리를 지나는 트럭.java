// import java.util.*;

// class Solution {
//     class Truck {
//         int weight;
//         int moveCnt;
        
//         Truck(int weight) {
//             this.weight = weight;
//             this.moveCnt = 1;
//         }
        
//         void moving() {
//             moveCnt++;
//         }
//     }
    
//     public int solution(int bridge_length, int weight, int[] truck_weights) {
//         int answer = 0;
        
//         Queue<Truck> waitQ = new ArrayDeque<>();
//         Queue<Truck> moveQ = new ArrayDeque<>();
        
//         for(int tWeight : truck_weights) {
//             waitQ.offer(new Truck(tWeight));
//         }
        
//         int totWeight = 0;
        
//         while(!waitQ.isEmpty() || !moveQ.isEmpty()) {
//             answer++;
            
//             for(Truck truck : moveQ) {
//                 truck.moving();
//             }
            
//             if(!moveQ.isEmpty() && moveQ.peek().moveCnt > bridge_length) {
//                 Truck truck = moveQ.poll();
//                 totWeight -= truck.weight;
//             }
                                                
//             if(!waitQ.isEmpty() && totWeight + waitQ.peek().weight <= weight) {
//                 Truck truck = waitQ.poll();
//                 totWeight += truck.weight;
//                 moveQ.offer(truck);
//             }
//         }
        
//         return answer;
//     }
// }


import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new ArrayDeque<>();

        int time = 0;
        int totalWeight = 0;

        for (int truck : truck_weights) {
            time++;

            // 현재 시각까지 다리를 건넌 트럭 제거
            while (!bridge.isEmpty() && bridge.peek()[1] <= time) {
                totalWeight -= bridge.poll()[0];
            }

            // 하중 또는 다리 위 트럭 수 제한에 걸리는 경우
            while (!bridge.isEmpty() && (totalWeight + truck > weight || bridge.size() >= bridge_length)) {

                // 가장 앞 트럭의 퇴장 시각으로 이동
                time = bridge.peek()[1];

                while (!bridge.isEmpty() && bridge.peek()[1] <= time) {
                    totalWeight -= bridge.poll()[0];
                }
            }

            bridge.offer(new int[] {truck, time + bridge_length});
            totalWeight += truck;
        }

        return time + bridge_length;
    }
}
