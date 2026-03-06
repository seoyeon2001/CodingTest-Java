import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(num != 0) {
                if(num < 0) {
                    pq.add(new int[] {Math.abs(num), 0});
                } else {
                    pq.add(new int[] {num, 1});
                }
            } else {
                if(!pq.isEmpty()) {
                    int[] answer = pq.poll();

                    if(answer[1] == 0) {
                        sb.append(-answer[0]).append("\n");
                    } else {
                        sb.append(answer[0]).append("\n");
                    }
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
