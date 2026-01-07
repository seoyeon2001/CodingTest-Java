import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long answer = 0;
        long i = 1;

        // i <= k 까지만 의미 있음
        while (i <= n && i <= k) {
            long q = k / i;          // 몫
            long last = k / q;       // 같은 몫이 유지되는 마지막 i

            if (last > n) last = n;

            long cnt = last - i + 1;             // 구간 길이
            long sumI = (i + last) * cnt / 2;    // i ~ last 합

            // Σ(k % x) = cnt * k - q * Σx
            answer += cnt * k - q * sumI;

            i = last + 1;
        }

        // i > k 인 구간: k % i == k
        if (i <= n) {
            answer += (n - i + 1) * k;
        }

        System.out.println(answer);
    }
}
