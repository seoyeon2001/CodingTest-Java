import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int res = (int) gcd(a, b);

        System.out.println(String.valueOf(1).repeat(res));
    }

    static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
