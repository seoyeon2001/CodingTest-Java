import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] indegree = new int[n+1];
        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] timeArr = new int[n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            timeArr[i] = time;

            while(true) {
                int input = Integer.parseInt(st.nextToken());

                if(input == -1) break;

                indegree[i]++;
                list[input].add(i);
            }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) q.add(new int[] {i, timeArr[i]});
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();
            timeArr[now[0]] = now[1];
            
            for(int num : list[now[0]]) {
                indegree[num]--;

                if(indegree[num] == 0) q.add(new int[] {num, timeArr[num] + timeArr[now[0]]});
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(timeArr[i]);
        }
    }
}
