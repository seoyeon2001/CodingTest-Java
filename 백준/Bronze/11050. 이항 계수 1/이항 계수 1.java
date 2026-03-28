import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        int answer = calc(n, r);
        System.out.println(answer);
    }

    static int calc(int n, int r) {
        if(r == 0) return 1;

        if(n == r) return 1;

        return calc(n-1, r) + calc(n-1, r-1);
    }
}
