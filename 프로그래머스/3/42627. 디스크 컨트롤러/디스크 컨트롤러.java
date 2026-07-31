import java.util.*;

class Solution {
    class Disk {
        int duration; // 소요 시간
        int arrival; // 도착 시간
        
        Disk(int duration, int arrival) {
            this.duration = duration;
            this.arrival = arrival;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        int totalJobCnt = jobs.length;
        
        // 요청 시간 순서대로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Disk> waitingPQ = new PriorityQueue<>((a, b) -> {
            if(a.duration == b.duration) {
                return a.arrival - b.arrival;
            }
            return a.duration - b.duration;
        });
        
        int nextIndex = 0; // 다음 작업 번호
        int time = 0;
        int cnt = 0;
        
        while(cnt < totalJobCnt) {
            
            while(nextIndex < totalJobCnt && jobs[nextIndex][0] <= time) {                
                waitingPQ.add(new Disk(jobs[nextIndex][1], jobs[nextIndex][0]));
                nextIndex++;
            }
            
            if(!waitingPQ.isEmpty()) {
                Disk disk = waitingPQ.poll();
                // System.out.println("다음 작업은 "+disk.arrival+"초에 도착한 "+disk.duration+"초 걸리는 작업");

                time += disk.duration;
                answer += time - disk.arrival;
                cnt++;
                // System.out.println(time + " " + answer);
            } else {
                time = jobs[nextIndex][0];
            }
            
            
        }
        
        return answer / totalJobCnt;
    }
}