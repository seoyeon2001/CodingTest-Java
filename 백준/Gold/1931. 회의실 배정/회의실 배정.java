import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new int[] {start, end});
        }

        int answer = 1;
        int[] first = pq.poll();
        int endTime = first[1];
        for(int i = 1; i < n; i++) {
            int[] meeting = pq.poll();
            if(meeting[0] < endTime) continue;

            endTime = meeting[1];
            answer++;
        }
        System.out.println(answer);
    }
}
