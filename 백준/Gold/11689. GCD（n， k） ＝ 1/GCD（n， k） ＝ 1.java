import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long answer = n;

        for(long p = 2; p <= Math.sqrt(n); p++) {
            if(n % p == 0) { // n의 소인수일 때
                answer -= answer / p;
                while(n % p == 0) {
                    n /= p;
                }
            }
        }

        if(n > 1) answer -= answer / n;

        System.out.println(answer);
    }
}
