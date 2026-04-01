import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] cnt = new int[n+1];

        for(int i = 2; i <= n; i++) {
            cnt[i] = cnt[i-1]+1;

            if(i % 3 == 0) {
                cnt[i] = Math.min(cnt[i], cnt[i/3]+1);
            } if(i % 2 == 0) {
                cnt[i] = Math.min(cnt[i], cnt[i/2]+1);
            }
//            System.out.println("cnt = " + Arrays.toString(cnt));
        }

        System.out.println(cnt[n]);
    }
}
