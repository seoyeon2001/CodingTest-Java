import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 최대공약수 GCD 구하기
            int gcd = gcd(a, b);

            sb.append(a*b / gcd).append("\n");
        }
        System.out.println(sb);
    }

    static int gcd(int n1, int n2) {
        int rest = n1 % n2;

        if(rest != 0) return gcd(n2, rest);

        return n2;
    }
}
