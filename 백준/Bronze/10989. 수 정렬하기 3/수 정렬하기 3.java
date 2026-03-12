import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] cnt = new int[10001];
        for(int i = 0; i < n; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
        }

        // 출력
        for(int i = 1; i < 10001; i++) {
            if(cnt[i] != 0) {
                while(cnt[i] > 0) {
                    sb.append(i).append("\n");
                    cnt[i]--;
                }
            }
        }
        System.out.println(sb);
    }
}
