import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n+1];
        int[] y = new int[n+1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[n] = x[0];
        y[n] = y[0];

        double sum = 0;
        for(int i = 0; i < n; i++) {
            int j = (i+1) % n;

            sum += (double) x[i] * y[j];
            sum -= (double) x[j] * y[i];
        }

        sum = Math.abs(sum);

        sum /= 2;

        System.out.printf("%.1f", sum);
    }
}
