import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        int[] cnt = new int[2000001];
        for(int i = 0; i < n; i++) {
            cnt[Integer.parseInt(br.readLine())+1000000]++;
        }

        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] != 0)
                sb.append(String.valueOf(i - 1000000).repeat(cnt[i])).append('\n');
        }

        System.out.println(sb);
    }
}
