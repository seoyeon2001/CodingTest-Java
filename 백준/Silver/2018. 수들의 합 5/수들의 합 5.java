import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int s = 1, e = 1;

        int sum = 1;
        int answer = 0;
        while(s <= e) {
//            System.out.println("s = " + s + " e = " + e + " sum = " + sum);
            if(sum == n) answer++;

            if(sum >= n) {
                sum -= s;
                s++;
            } else {
                e++;
                sum += e;
            }
        }
        System.out.println(answer);
    }
}
