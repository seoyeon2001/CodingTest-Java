import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int max = (int) Math.sqrt(b);

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i <= max; i++) {
            if(!isPrime[i]) continue;

            for(int j = i*2; j <= max; j += i) {
                isPrime[j] = false;
            }
        }

        int answer = 0;
        for(int i = 2; i <= max; i++) {
            if(isPrime[i]) {
                long num = (long) i*i;

                while(num <= b) {
                    if(num >= a) {
//                        System.out.println("num = " + num);
                        answer++;
                    }

                    if(num > b / i) break;

                    num *= i;
                }
            }
        }

        System.out.println(answer);
    }
}
