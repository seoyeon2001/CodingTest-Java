import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> b -a);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int oneCnt = 0;
        int zeroCnt = 0;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) oneCnt++;
            else if(num > 0) pq1.add(num);
            else if (num < 0) pq2.add(num);
            else zeroCnt++;
        }

        int answer = 0;

        // 양수 계산
        while(pq1.size() >= 2) {
            int num1 = pq1.poll();
            int num2 = pq1.poll();

            answer += num1 * num2;
        }

        // 큐에 남은 값 더하기
        while(!pq1.isEmpty()) {
            answer += pq1.poll();
        }

        // 1 개수만큼 더하기
        answer += oneCnt;

        // 음수 계산
        while(pq2.size() >= 2) {
            int num1 = pq2.poll();
            int num2 = pq2.poll();

            answer += num1 * num2;
        }

        // 홀수 1개 남았을 때
        if(pq2.size() == 1 && zeroCnt == 0) {
            answer += pq2.poll();
        }

        System.out.println(answer);
    }
}
