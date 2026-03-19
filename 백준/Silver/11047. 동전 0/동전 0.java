import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int idx = n-1;
        while(k > 0) {
            if(k >= arr[idx]) {
                answer += k / arr[idx];
                k %= arr[idx];
            }
            idx--;
        }
        System.out.println(answer);
    }
}
