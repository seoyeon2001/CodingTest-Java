import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];

        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        int k = Integer.parseInt(br.readLine());

        if(m == 1 || k == 1) {
            System.out.println(1.0);
            return;
        }

        double answer = 0.0;

        for(int i = 0; i < m; i++) {
            if(arr[i] < k) continue;

            double pro = 1.0;
            for(int j = 0; j < k; j++) {
                pro *= (double) (arr[i] - j) / (total - j);
            }
//            System.out.println("pro = " + pro);
            answer += pro;
//            System.out.println("answer = " + answer);
        }

        System.out.println(answer);
    }
}
