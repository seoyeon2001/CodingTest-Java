import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cnt = new int[n+1];

        for(int i = 2; i <= n; i++) {
            int answer = i-1;

            if(i % 3 == 0 && i % 2 == 0) {
                answer = Math.min(cnt[i-1], Math.min(cnt[i/3], cnt[i/2]));
            } else if(i % 3 == 0 && i % 2 != 0) {
                answer = Math.min(cnt[i-1], cnt[i/3]);
            } else if(i % 3 != 0 && i % 2 == 0) {
                answer = Math.min(cnt[i-1], cnt[i/2]);
            } else {
                answer = cnt[i-1];
            }

            cnt[i] = answer+1;
//            System.out.println("cnt = " + Arrays.toString(cnt));
        }

        System.out.println(cnt[n]);
    }
}
