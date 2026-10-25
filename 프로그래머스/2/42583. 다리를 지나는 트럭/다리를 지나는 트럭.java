import java.util.*;

class Solution {
    class Truck {
        int weight;
        int moveCnt;
        
        Truck(int weight) {
            this.weight = weight;
            this.moveCnt = 1;
        }
        
        void moving() {
            moveCnt++;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Truck> waitQ = new ArrayDeque<>();
        Queue<Truck> moveQ = new ArrayDeque<>();
        
        for(int tWeight : truck_weights) {
            waitQ.offer(new Truck(tWeight));
        }
        
        int totWeight = 0;
        
        while(!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;
            
            for(Truck truck : moveQ) {
                truck.moving();
            }
            
            if(!moveQ.isEmpty() && moveQ.peek().moveCnt > bridge_length) {
                Truck truck = moveQ.poll();
                totWeight -= truck.weight;
            }
                                                
            if(!waitQ.isEmpty() && totWeight + waitQ.peek().weight <= weight) {
                Truck truck = waitQ.poll();
                totWeight += truck.weight;
                moveQ.offer(truck);
            }
            
            
        }
        
        return answer;
    }
}