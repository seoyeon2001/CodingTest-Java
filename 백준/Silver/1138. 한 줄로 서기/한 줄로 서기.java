import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[n];
        int[] ans = new int[n];

        int start = 1;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int idx = Integer.parseInt(st.nextToken());

            int time = 0;
            for(int j = 0; j < n; j++) {
                if(!visited[j]) {
                    if(idx == time) {
                        ans[j] = start;
                        visited[j] = true;
                        break;
                    }

                    time++;
                }
            }

            start++;
        }

        for(int i : ans) {
            System.out.print(i + " ");
        }



    }
}
